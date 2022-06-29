package steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BuildConfigConfigurationPage
import java.time.Duration

class BuildConfigConfigurationSteps : BuildConfigConfigurationPage() {

    @Step("Click on Run button")
    fun clickRunButton() : BuildConfigConfigurationSteps {
        runButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        runButton.click()
        return this
    }

    @Step("Click on Show more general settings link if there is one")
    fun showMoreGeneralSettings() : BuildConfigConfigurationSteps {
        if (showMoreGeneralSettingsButton.`is`(Condition.visible)) {
            showMoreGeneralSettingsButton.click()
        }
        return this
    }

    @Step("Click on Dependencies menu item")
    fun clickDependenciesMenuItem() : BuildConfigConfigurationSteps {
        dependenciesMenuItem.shouldBe(Condition.visible, Duration.ofMinutes(1))
        dependenciesMenuItem.click()
        return this
    }

    @Step("Click on Triggers menu item")
    fun clickTriggersMenuItem() : BuildConfigConfigurationSteps {
        triggersMenuItem.shouldBe(Condition.visible, Duration.ofMinutes(1))
        triggersMenuItem.click()
        return this
    }

    @Step("Click on Add new snapshot dependency button")
    fun clickAddNewSnapshotDependencyButton() : BuildConfigConfigurationSteps {
        addNewSnapshotDependencyButton.shouldBe(Condition.visible, Duration.ofMinutes(1))
        addNewSnapshotDependencyButton.click()
        return this
    }

    @Step("Click on Add new artifact dependency button")
    fun clickAddNewArtifactDependencyButton() : BuildConfigConfigurationSteps {
        addNewArtifactDependencyButton.shouldBe(Condition.visible, Duration.ofMinutes(1))
        addNewArtifactDependencyButton.click()
        return this
    }

    @Step("Click on Add new trigger button")
    fun clickAddNewTriggerButton() : BuildConfigConfigurationSteps {
        addNewTriggerButton.shouldBe(Condition.visible, Duration.ofMinutes(1))
        addNewTriggerButton.click()
        return this
    }

    @Step("Checking if snapshot dependency was updated")
    fun snapshotDependenciesShouldBeUpdated(dependency : String) : BuildConfigConfigurationSteps {
        snapshotDependenciesUpdatedMessage.shouldBe(Condition.visible, Duration.ofMinutes(1))
        snapshotDependenciesTable.`$x`(".//a[normalize-space()='$dependency']").shouldBe(Condition.visible, Duration.ofMinutes(1))
        return this
    }

    @Step("Checking if artifact dependency was updated")
    fun artifactDependenciesShouldBeUpdated(dependency : String) : BuildConfigConfigurationSteps {
        artifactDependenciesUpdateMessage.shouldBe(Condition.visible, Duration.ofMinutes(1))
        artifactDependenciesTable.`$x`(".//a[normalize-space()='$dependency']").shouldBe(Condition.visible, Duration.ofMinutes(1))
        return this
    }

    @Step("Checking if trigger was updated")
    fun triggersShouldBeUpdated(trigger : String) : BuildConfigConfigurationSteps {
        buildTriggerMessage.shouldBe(Condition.visible, Duration.ofMinutes(1))
        triggersTable.shouldHave(Condition.text(trigger), Duration.ofSeconds(30))
        return this
    }
}