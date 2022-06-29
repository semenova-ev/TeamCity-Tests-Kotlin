package tests

import api.BuildConfigAPI
import api.ProjectAPI
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.*
import testData.MainTestConfiguration
import testData.Users


class QuickStartTests : MainTestConfiguration() {
    private val SOURCE_PROJECT_NAME = "BuildActionsProject"
    private val SOURCE_BUILD_ID = "BuildActionsProject_BuildEmpty"
    private val NEW_BUILD_NAME = "Build"
    private val NEW_BUILD_ID = "BuildActionsProject_Build"

    private var teamCityUISteps = TeamCityUISteps()
    private var administrationSteps = AdministrationSteps()
    private var createProjectSteps = CreateProjectSteps()
    private var createProjectFromURLSteps = CreateProjectFromURLSteps()
    private var projectSteps = ProjectSteps()
    private var buildConfigSteps = BuildConfigSteps()
    private var buildConfigConfigurationSteps = BuildConfigConfigurationSteps()

    companion object {
        @BeforeAll
        @JvmStatic
        internal  fun beforeAll() {
            SelenideLogger.addListener("allure", AllureSelenide())
            configure()
        }
    }

    @Test
    @Description("Authorization with Administrator username and password")
    fun authorizationWithUserNamePass() {
        Selenide.sleep(3000)
        val neededUrl = Configuration.baseUrl + "/favorite/projects"
        val currentUrl = WebDriverRunner.getWebDriver().currentUrl
        Assertions.assertTrue(currentUrl.contains(neededUrl))
    }

    @Test
    @Description("Create First Project")
    fun createProjectTest() {
        val projectName = "FirstProject"
        val projectId = "FirstProject"
        val repositoryURL = "https://github.com/semenova-ev/FirstProject"

        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.deleteProject(projectId)

        teamCityUISteps
            .openFavoriteProjects()
            .openAdministration()
        administrationSteps
            .clickCreateProjectButton()
        createProjectSteps
            .clickFromRepositoryURL()
            .setParentProject("<Root project>")
            .setRepositoryURL(repositoryURL)
            .clickProceedButton()
        createProjectFromURLSteps
            .clickProceedButton()
            .shouldHaveNoSettingsSuccessMessage()
            .checkMaven()
            .clickUseSelectedButton()
        teamCityUISteps
            .openFavoriteProjects()
            .openProject(projectName)
        projectSteps
            .openBuild("Build")

        createdProject.deleteProject(projectId)
    }

    @Test
    @Description("Run First Build from Build Conf Page")
    fun runBuildFromBuildConfPage() {
        val bc = BuildConfigAPI(Users.mainUsertoken)
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .clickEditConfigurationButton()
        buildConfigConfigurationSteps
            .clickRunButton()
        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()

        bc.deleteBuildConfiguration()
    }
}