package steps.modalDialogs

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import io.qameta.allure.Step
import pages.modalDialogs.SnapshotDependencyDialogPage
import java.time.Duration

class SnapshotDependencyDialogSteps : SnapshotDependencyDialogPage() {

    @Step("Checking if Add new snapshot dependency modal window is appear")
    fun addNewSnapshotDependencyDialogShouldAppear() : SnapshotDependencyDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        windowHeader.shouldHave(Condition.text("Add New Snapshot Dependency"))
        return this
    }

    @Step("Select build configuration '{buildConfig}' from '{projectName}' project")
    fun selectDependency(projectName: String, buildConfig: String): SnapshotDependencyDialogSteps {
        val treeItem = projectsTree.`$x`(".//input[@id='" + Configuration.baseUrl + "_search_buildType_" + projectName + "_" + buildConfig + "']")
        treeItem.should(Condition.exist, Duration.ofSeconds(30))
        treeItem.click()
        return this
    }

    @Step("Click on Save button")
    fun clickSaveButton() : SnapshotDependencyDialogSteps {
        saveButton.scrollTo()
        saveButton.click()
        return this
    }
}