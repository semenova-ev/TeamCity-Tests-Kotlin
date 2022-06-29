package tests

import api.BuildConfigAPI
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.Description
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.*
import steps.modalDialogs.*
import testData.MainTestConfiguration

class MainActionsOnBuildTests : MainTestConfiguration() {

    private val SOURCE_PROJECT_NAME = "BuildActionsProject"
    private val SOURCE_BUILD_ID = "BuildActionsProject_BuildEmpty"
    private val NEW_BUILD_NAME = "Build"
    private val NEW_BUILD_ID = "BuildActionsProject_Build"

    private var teamCityUISteps = TeamCityUISteps()
    private var projectSteps = ProjectSteps()
    private var buildConfigSteps = BuildConfigSteps()
    private var buildDropdownMenuSteps = BuildDropdownMenuSteps()
    private var pinBuildDialogSteps = PinBuildDialogSteps()
    private var buildSteps = BuildSteps()
    private var addTagsDialogSteps = AddTagsDialogSteps()
    private var rerunBuildDialogSteps = RerunBuildDialogSteps()
    private var stopBuildDialogSteps = StopBuildDialogSteps()
    private var removeBuildDialogSteps = RemoveBuildDialogSteps()

    companion object {
        @BeforeAll
        @JvmStatic
        internal  fun beforeAll() {
            SelenideLogger.addListener("allure", AllureSelenide())
            configure()
        }
    }

    @Test
    @Description("Manually Run Build")
    fun manuallyRunBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .runBuild()
            .shouldHaveStatusPassed()

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Pin Build")
    fun pinBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .openBuildDropDownMenu()
        buildDropdownMenuSteps
            .clickPinItem()
        pinBuildDialogSteps
            .pinModalDialogShouldAppear()
            .setPinMessage("001rc")
            .clickPinButton()
        buildConfigSteps
            .showBuildInfo()
        buildSteps
            .shouldHavePinMessage("001rc")

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Add Tags to Build")
    fun addTagsToBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .openBuildDropDownMenu()
        buildDropdownMenuSteps
            .clickAddTagsItem()
        addTagsDialogSteps
            .addTagModalDialogShouldAppear()
            .setTag("release")
            .clickSaveButton()
        buildConfigSteps
            .showBuildInfo()
        buildSteps
            .shouldHaveTag("release")

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Re-run Build")
    fun reRunBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .openBuildDropDownMenu()
        buildDropdownMenuSteps
            .clickReRunItem()
        rerunBuildDialogSteps
            .rerunBuildModalDialogShouldAppear()
            .clickRunButton()
        buildConfigSteps
            .shouldHaveSecondBuild()

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Re-run Build")
    fun stopBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .runBuild()
            .stopBuild()
        stopBuildDialogSteps
            .stopBuildModalDialogShouldAppear()
            .clickStopButton()
        buildConfigSteps
            .shouldHaveStatusCanceled()

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Remove Build")
    fun removeBuildTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .openBuildDropDownMenu()
        buildDropdownMenuSteps
            .clickRemoveItem()
        removeBuildDialogSteps
            .removeBuildModalDialogShouldAppear()
            .clickRemoveButton()
        buildConfigSteps
            .shouldHaveNoBuilds()

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Download Build Artifact on Build Results Page")
    fun downloadBuildArtifactTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .showBuildInfo()
        buildSteps
            .openArtifactsTab()
            .checkBuildFile()

        bc.deleteBuildConfiguration()
    }

    @Test
    @Description("Add Build to Favorites")
    fun addBuildToFavoriteTest() {
        val bc = BuildConfigAPI(getUserToken())
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID)
        bc.runBuild()

        teamCityUISteps
            .openFavoriteProjects()
            .openProject(SOURCE_PROJECT_NAME)
        projectSteps
            .openBuild(NEW_BUILD_NAME)
        buildConfigSteps
            .shouldHaveStatusPassed()
            .openBuildDropDownMenu()
        buildDropdownMenuSteps
            .clickAddToFavoritesItem()
        buildConfigSteps
            .shouldBeInFavorites()

        bc.deleteBuildConfiguration()
    }
}