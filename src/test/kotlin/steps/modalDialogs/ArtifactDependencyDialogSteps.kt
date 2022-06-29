package steps.modalDialogs

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import io.qameta.allure.Step
import pages.modalDialogs.ArtifactDependencyDialogPage
import java.time.Duration

class ArtifactDependencyDialogSteps : ArtifactDependencyDialogPage() {

    @Step("Checking if Add new artifact dependency modal window is appear")
    fun addNewArtifactDependencyDialogShouldAppear() : ArtifactDependencyDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        windowHeader.shouldHave(Condition.text("Add New Artifact Dependency"))
        return this
    }

    @Step("Click on Select build configuration button")
    fun clickSelectBuildConfigButton() : ArtifactDependencyDialogSteps {
        selectBuildConfigButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        selectBuildConfigButton.click()
        return this
    }

    @Step("Select build configuration '{buildConfig}' from '{project}' project")
    fun selectBuildConfiguration(project: String, buildConfig: String) : ArtifactDependencyDialogSteps {
        artifactFromArea.shouldBe(Condition.visible, Duration.ofSeconds(30))
        artifactFromArea.`$x`(".//div[@id='" + Configuration.baseUrl + "_search_project_" + project + "']").shouldBe(
            Condition.visible, Duration.ofSeconds(30)).click()
        artifactFromArea.`$x`(".//div[@id='" + Configuration.baseUrl + "_search_buildType_" + project + "_" + buildConfig + "']").shouldBe(
            Condition.visible, Duration.ofSeconds(30)).click()
        return this
    }

    @Step("Enter artifact rules '{rules}'")
    fun setArtifactRules(rules: String) : ArtifactDependencyDialogSteps {
        artifactRules.shouldBe(Condition.visible, Duration.ofSeconds(30))
        artifactRules.setValue(rules)
        return this
    }

    @Step("Click on Save button")
    fun clickSaveButton() : ArtifactDependencyDialogSteps {
        saveButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        saveButton.click()
        return this
    }
}