package tests

import api.ProjectAPI
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.*
import steps.modalDialogs.*
import testData.MainTestConfiguration
import testData.Users

class BuildChainTests : MainTestConfiguration() {
    private val NEW_PROJECT_NAME = "Pipeline"
    private val NEW_PROJECT_ID = "Pipeline"
    private val SOURCE_PROJECT_ID = "PipelineEmpty"
    private val SOURCE_FULL_PROJECT_ID = "PipelineFull"

    private var teamCityUISteps = TeamCityUISteps()
    private var administrationSteps = AdministrationSteps()
    private var createProjectSteps = CreateProjectSteps()
    private var createProjectFromURLSteps = CreateProjectFromURLSteps()
    private var projectSteps = ProjectSteps()
    private var buildConfigSteps = BuildConfigSteps()
    private var buildConfigConfigurationSteps = BuildConfigConfigurationSteps()
    private var snapshotDependencyDialogSteps = SnapshotDependencyDialogSteps()
    private var artifactDependencyDialogSteps = ArtifactDependencyDialogSteps()
    private var editTriggerDialogSteps = EditTriggerDialogSteps()

    companion object {
        @BeforeAll
        @JvmStatic
        internal  fun beforeAll() {
            SelenideLogger.addListener("allure", AllureSelenide())
            configure()
        }
    }

    @Test
    @Description("Create Build Chain Project")
    fun createBuildChainProjectTest() {
        val projectName = "Pipeline"
        val projectId = "Pipeline"
        val repositoryURL = "https://github.com/semenova-ev/Pipeline"

        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.deleteProject(projectId)

        teamCityUISteps
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
            .shouldHaveSuccessMessage()
        teamCityUISteps
            .openFavoriteProjects()
            .openProject(projectName)
        projectSteps
            .shouldHaveBuild("App")
            .shouldHaveBuild("Test")
            .shouldHaveBuild("TestReport")
            .shouldHaveBuild("Deploy")

        createdProject.deleteProject(projectId)
    }

    @Test
    @Description("Configure Snapshot Dependency")
    fun configureSnapshotDependencyTest() {
        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(NEW_PROJECT_NAME)
        projectSteps
            .openBuild("TestReport")
        buildConfigSteps
            .clickEditConfigurationButton()
        buildConfigConfigurationSteps
            .showMoreGeneralSettings()
            .clickDependenciesMenuItem()
            .clickAddNewSnapshotDependencyButton()
        snapshotDependencyDialogSteps
            .addNewSnapshotDependencyDialogShouldAppear()
            .selectDependency(NEW_PROJECT_NAME, "Test")
            .clickSaveButton()
        buildConfigConfigurationSteps
            .snapshotDependenciesShouldBeUpdated("Test")

        createdProject.deleteProject()
    }

    @Test
    @Description("Configure Artifact Dependency")
    fun configureArtifactDependencyTest() {
        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(NEW_PROJECT_NAME)
        projectSteps
            .openBuild("Deploy")
        buildConfigSteps
            .clickEditConfigurationButton()
        buildConfigConfigurationSteps
            .showMoreGeneralSettings()
            .clickDependenciesMenuItem()
            .clickAddNewArtifactDependencyButton()
        artifactDependencyDialogSteps
            .addNewArtifactDependencyDialogShouldAppear()
            .clickSelectBuildConfigButton()
            .selectBuildConfiguration(NEW_PROJECT_NAME, "App")
            .setArtifactRules("app.jar => build/libs/app.jar")
            .clickSaveButton()
        buildConfigConfigurationSteps
            .artifactDependenciesShouldBeUpdated("App")


        createdProject.deleteProject()
    }

    @Test
    @Description("Add VCS Trigger")
    fun addVCSTriggerTest() {
        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(NEW_PROJECT_NAME)
        projectSteps
            .openBuild("Deploy")
        buildConfigSteps
            .clickEditConfigurationButton()
        buildConfigConfigurationSteps
            .showMoreGeneralSettings()
            .clickTriggersMenuItem()
            .clickAddNewTriggerButton()
        editTriggerDialogSteps
            .addNewTriggerDialogShouldAppear()
            .selectTrigger("VCS Trigger")
            .showAdvancedOptions()
            .checkTriggerBuildOnChangesCheck()
            .clickSaveButton()
        buildConfigConfigurationSteps
            .triggersShouldBeUpdated("VCS Trigger")

        createdProject.deleteProject()
    }

    @Test
    @Description("Manually Run Simple Chain")
    fun manuallyRunSimpleChainTest() {
        val createdProject = ProjectAPI(Users.mainUsertoken)
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_FULL_PROJECT_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(NEW_PROJECT_NAME)
        projectSteps
            .openBuild("Deploy")
        buildConfigSteps
            .clickDeployButton()
        teamCityUISteps
            .openProject(NEW_PROJECT_NAME)
        projectSteps
            .openBuildChainTab()
            .shouldDeploySuccessful()

        createdProject.deleteProject()
    }
}