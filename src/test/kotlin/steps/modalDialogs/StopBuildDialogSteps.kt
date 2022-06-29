package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.StopBuildDialogPage
import java.time.Duration

class StopBuildDialogSteps : StopBuildDialogPage() {

    @Step("Stop build dialog window should appear")
    fun stopBuildModalDialogShouldAppear() : StopBuildDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        window.shouldHave(Condition.text("Stop build"))
        return this
    }

    @Step("Click on Stop button")
    fun clickStopButton() : StopBuildDialogSteps {
        stopButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        stopButton.click()
        return this
    }
}