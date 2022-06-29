package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.RemoveBuildDialogPage
import java.time.Duration

class RemoveBuildDialogSteps : RemoveBuildDialogPage() {

    @Step("Remove Build dialog window should appear")
    fun removeBuildModalDialogShouldAppear() : RemoveBuildDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        window.shouldHave(Condition.text("Remove build"))
        return this
    }

    @Step("Click on Remove button")
    fun clickRemoveButton() : RemoveBuildDialogSteps {
        removeButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        removeButton.click()
        return this
    }
}