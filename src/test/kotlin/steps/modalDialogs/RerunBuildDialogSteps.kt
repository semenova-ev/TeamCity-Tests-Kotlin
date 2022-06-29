package steps.modalDialogs

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.modalDialogs.RerunBuildDialogPage
import java.time.Duration

class RerunBuildDialogSteps : RerunBuildDialogPage() {

    @Step("Rerun Build dialog window should appear")
    fun rerunBuildModalDialogShouldAppear() : RerunBuildDialogSteps {
        window.shouldBe(Condition.visible, Duration.ofSeconds(30))
        window.shouldHave(Condition.text("Run Custom Build"))
        return this
    }

    @Step("Click on Run button")
    fun clickRunButton() : RerunBuildDialogSteps {
        runButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        runButton.click()
        return this
    }
}