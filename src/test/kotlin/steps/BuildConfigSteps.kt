package steps

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.*
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BuildConfigPage
import java.time.Duration

class BuildConfigSteps : BuildConfigPage() {

    @Step("Click Run build button")
    fun runBuild() : BuildConfigSteps {
        runBuildButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        runBuildButton.click()
        return this
    }

    @Step("Click on Stop build button")
    fun stopBuild() : BuildConfigSteps {
        stopBuildFastButton.shouldBe(visible, Duration.ofMinutes(1))
        stopBuildFastButton.click()
        return this
    }

    @Step("Check if build has status Passed")
    fun shouldHaveStatusPassed() : BuildConfigSteps {
        buildStatusPassed.shouldBe(visible, Duration.ofMinutes(5))
        return this
    }

    @Step("Check if build has status Success")
    fun shouldHaveStatusSuccess() : BuildConfigSteps {
        buildStatusSuccess.shouldBe(Condition.visible, Duration.ofMinutes(10))
        return this
    }

    @Step("Check if build has status Canceled")
    fun shouldHaveStatusCanceled() : BuildConfigSteps {
        buildStatusCanceled.shouldBe(visible, Duration.ofMinutes(1))
        return this
    }

    @Step("Check if there is second build")
    fun shouldHaveSecondBuild() : BuildConfigSteps {
        buildsContainer.shouldHave(text("#2"), Duration.ofSeconds(60));
        return this
    }

    @Step("Check if there are no builds")
    fun shouldHaveNoBuilds() : BuildConfigSteps {
        warningsBlock.shouldBe(visible, Duration.ofSeconds(30))
        warningsBlock.shouldHave(text("No builds found in whole build history"))
        return this
    }

    @Step("Check if there is Favorite icon")
    fun shouldBeInFavorites() : BuildConfigSteps {
        favoritesOffFastButton.shouldBe(visible, Duration.ofSeconds(30))
        return this
    }

    @Step("Click on Edit configuration button")
    fun clickEditConfigurationButton() : BuildConfigSteps {
        editConfigurationButton.shouldBe(visible, Duration.ofSeconds(30))
        editConfigurationButton.click()
        return this
    }

    @Step("Click on build menu (...)")
    fun openBuildDropDownMenu() : BuildConfigSteps {
        buildLoading.shouldNot(exist, Duration.ofMinutes(1))
        dropDownMenuButton.shouldBe(visible, Duration.ofSeconds(30))
        dropDownMenuButton.click()
        return this
    }

    @Step("Show build information")
    fun showBuildInfo() : BuildConfigSteps {
        buildStatusArea.shouldBe(visible, Duration.ofSeconds(30))
        buildStatusArea.click()
        return this
    }

    @Step("Click on Deploy button")
    fun clickDeployButton() : BuildConfigSteps {
        deployButton.shouldBe(visible, Duration.ofSeconds(30))
        deployButton.click()
        return this
    }
}