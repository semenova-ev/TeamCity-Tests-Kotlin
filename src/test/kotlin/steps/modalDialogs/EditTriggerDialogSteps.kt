package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.EditTriggerDialogPage
import java.time.Duration

class EditTriggerDialogSteps : EditTriggerDialogPage() {

    @Step("Checking if Add new trigger modal window is appear")
    fun addNewTriggerDialogShouldAppear() : EditTriggerDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        windowHeader.shouldHave(Condition.text("Add New Trigger"))
        return this
    }

    @Step("Select '{trigger}' trigger")
    fun selectTrigger(trigger: String) : EditTriggerDialogSteps {
        triggerComboBoxDropDownButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        triggerComboBoxDropDownButton.click()
        triggerComboBoxList.`$x`(".//li[@data-title='$trigger']").shouldBe(Condition.visible, Duration.ofSeconds(30)).click()
        return this
    }

    @Step("Click on Show advanced options link if there is one")
    fun showAdvancedOptions() : EditTriggerDialogSteps {
        if (showAdvancedOptionsButton.`is`(Condition.visible)) {
            showAdvancedOptionsButton.click()
        }
        return this
    }

    @Step("Select Build on changes checkbox")
    fun checkTriggerBuildOnChangesCheck() : EditTriggerDialogSteps {
        triggerBuildOnChangesCheck.should(Condition.exist, Duration.ofSeconds(30))
        triggerBuildOnChangesCheck.setSelected(true)
        return this
    }

    @Step("Click on Save button")
    fun clickSaveButton() : EditTriggerDialogSteps {
        saveButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        saveButton.click()
        return this
    }
}