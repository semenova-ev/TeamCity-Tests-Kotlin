package steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.AdministrationPage
import java.time.Duration

class AdministrationSteps : AdministrationPage() {

    @Step("Click on Create project button")
    fun clickCreateProjectButton() : AdministrationSteps {
        createProjectButton.should(Condition.exist, Duration.ofMinutes(1))
        createProjectButton.click()
        return this
    }
}