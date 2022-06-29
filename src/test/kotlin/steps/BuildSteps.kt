package steps

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.download


import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import pages.BuildPage
import java.io.IOException
import java.time.Duration

class BuildSteps : BuildPage() {

    @Step("Check if there is pin message '{message}'")
    fun shouldHavePinMessage(message : String) : BuildSteps {
        pinnedInfoBlock.shouldBe(Condition.visible, Duration.ofSeconds(30))
        pinnedInfoBlock.shouldHave(Condition.text(message))
        return this
    }

    @Step("Check if tag '{tag}' is exists")
    fun shouldHaveTag(tag : String) : BuildSteps {
        tagsInfoBlock.shouldBe(Condition.visible, Duration.ofSeconds(30))
        tagsInfoBlock.shouldHave(Condition.text(tag))
        return this
    }

    @Step("Open artifacts tab")
    fun openArtifactsTab() : BuildSteps {
        artifactsTab.shouldBe(Condition.visible, Duration.ofSeconds(30))
        artifactsTab.click()
        return this
    }

    @Step("Check if artifact file downloaded successfully")
    fun checkBuildFile() : BuildSteps {
        artifactDownloadButton.shouldBe(Condition.visible, Duration.ofSeconds(30))
        var fileUrl = artifactDownloadButton.getAttribute("href")
        var downloadFile = download(fileUrl)
        Assertions.assertTrue(downloadFile.exists())
        downloadFile.delete()
        return this
    }
}