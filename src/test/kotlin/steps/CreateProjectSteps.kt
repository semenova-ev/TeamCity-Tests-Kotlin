package steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.CreateProjectPage
import java.time.Duration

class CreateProjectSteps : CreateProjectPage() {

    @Step("Click on From repository URL button")
    fun clickFromRepositoryURL() : CreateProjectSteps {
        fromRepositoryURLButton.shouldBe(Condition.visible, Duration.ofMinutes(1))
        fromRepositoryURLButton.click()
        return this
    }

    @Step("Choose parent project as '{parentProject}'")
    fun setParentProject(parentProject : String) : CreateProjectSteps {
        parentProjectInput.setValue(parentProject)
        return this
    }

    @Step("Enter repository URL '{url}'")
    fun setRepositoryURL(url : String) : CreateProjectSteps {
        repositoryURL.setValue(url)
        return this
    }

    @Step("Click on Proceed button")
    fun clickProceedButton() : CreateProjectSteps {
        proceedButton.shouldBe(Condition.visible, Duration.ofSeconds(10))
        proceedButton.click()
        return this
    }

}