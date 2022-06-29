package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.PinBuildDialogPage
import java.time.Duration

class PinBuildDialogSteps : PinBuildDialogPage() {

    @Step("Pin Build dialog window should appear")
    fun pinModalDialogShouldAppear() : PinBuildDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        window.shouldHave(Condition.text("Pin Build"))
        return this
    }

    @Step("Enter pin message '{message}'")
    fun setPinMessage(message : String) : PinBuildDialogSteps {
        pinMessageInput.shouldBe(Condition.visible, Duration.ofSeconds(30))
        pinMessageInput.setValue(message)
        return this
    }

    @Step("Click on Pin button")
    fun clickPinButton() : PinBuildDialogSteps {
        pinButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        pinButton.click()
        return this
    }
}