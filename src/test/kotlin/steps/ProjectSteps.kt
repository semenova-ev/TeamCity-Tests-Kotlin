package steps

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$x`
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.ProjectPage
import java.time.Duration

class ProjectSteps : ProjectPage() {

    @Step("Open build configuration '{buildName}'")
    fun openBuild(buildName : String) : ProjectSteps {
        Selenide.refresh()
        if (showAllConfigurationsButton.has(Condition.text("Show all"))) {
            showAllConfigurationsButton.click()
        }
        overviewTab.`$x`(".//a[normalize-space()='$buildName']").click()
        Selenide.refresh()
        return this
    }

    @Step("Check if the build configuration '{buildName}' exists")
    fun shouldHaveBuild(buildName : String) : ProjectSteps {

        if (showAllConfigurationsButton.has(Condition.text("Show all"))) {
            showAllConfigurationsButton.click()
        }
        overviewTab.`$x`(".//a[normalize-space()='$buildName']").shouldBe(Condition.visible, Duration.ofSeconds(30))
        return this
    }

    @Step("Open Build Chain tab")
    fun openBuildChainTab() : ProjectSteps {
        buildChainsTab.shouldBe(Condition.visible, Duration.ofSeconds(30))
        buildChainsTab.click()
        return this
    }

    @Step("Check if deploy was successful")
    fun shouldDeploySuccessful() : ProjectSteps {
        // Switch to `Classic UI tab` iframe
        Selenide.switchTo().defaultContent()
        Selenide.switchTo().frame("Classic UI tab")
        deploySuccessStatus.shouldBe(Condition.visible, Duration.ofMinutes(10))
        return this
    }
}