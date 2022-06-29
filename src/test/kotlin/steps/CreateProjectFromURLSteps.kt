package steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.CreateProjectFromURLPage
import java.time.Duration

class CreateProjectFromURLSteps : CreateProjectFromURLPage() {

    @Step("Click Proceed button")
    fun clickProceedButton() : CreateProjectFromURLSteps {
        vcsConnectionStatus.shouldBe(Condition.visible, Duration.ofMinutes(2))
        proceedButton.click()
        return this
    }

    @Step("Check if there is success message")
    fun shouldHaveNoSettingsSuccessMessage() : CreateProjectFromURLSteps {
        resultInfoBlockForNoSettingsProject.shouldHave(Condition.text("successfully"), Duration.ofMinutes(1))
        return this
    }

    @Step("Check if there is success message")
    fun shouldHaveSuccessMessage() : CreateProjectFromURLSteps {
        resultInfoBlock.shouldHave(Condition.text("successfully"), Duration.ofMinutes(1))
        return this
    }

    @Step("Select checkbox of build step")
    fun checkMaven() : CreateProjectFromURLSteps {
        mavenCheckBox.should(Condition.exist, Duration.ofSeconds(20))
        mavenCheckBox.click()
        return this
    }

    @Step("Click on Use selected button")
    fun clickUseSelectedButton() : CreateProjectFromURLSteps {
        useSelectedButton.shouldBe(Condition.visible, Duration.ofSeconds(10))
        useSelectedButton.click()
        return this
    }
}