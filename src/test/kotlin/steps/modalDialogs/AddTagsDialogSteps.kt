package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.AddTagsDialogPage
import java.time.Duration

class AddTagsDialogSteps : AddTagsDialogPage() {

    @Step("Add tag dialog window should appear")
    fun addTagModalDialogShouldAppear() : AddTagsDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        window.shouldHave(Condition.text("Add Build Tags"))
        return this
    }

    @Step("Add tag '{tag}'")
    fun setTag(tag : String) : AddTagsDialogSteps {
        addTagsInput.shouldBe(Condition.visible, Duration.ofSeconds(30))
        addTagsInput.setValue(tag)
        addTagConfirmButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        addTagConfirmButton.click()
        return this
    }

    @Step("")
    fun clickSaveButton() : AddTagsDialogSteps {
        saveButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        saveButton.click()
        return this
    }
}