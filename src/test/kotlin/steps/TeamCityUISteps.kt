package steps

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import pages.TeamCityUIPage
import java.time.Duration

class TeamCityUISteps : TeamCityUIPage() {

    @Step("Open projects page")
    fun openFavoriteProjects() : TeamCityUISteps {
        //headerPortal.shouldBe(Condition.visible, Duration.ofMinutes(1))
        //projectsMenuButton.click()
        Selenide.sleep(2000)
        Selenide.open("/favorite/projects")
        headerPortal.shouldBe(Condition.visible, Duration.ofMinutes(1))

        return this
    }

    @Step("Open Administration page")
    fun openAdministration() : TeamCityUISteps {
        administrationMenuButton.should(Condition.exist, Duration.ofMinutes(1))
        administrationMenuButton.click()
        return this
    }

    @Step("Open project {projectName}")
    fun openProject(projectName : String) : TeamCityUISteps {
        projectsTree.shouldBe(Condition.visible, Duration.ofMinutes(1))
        val projectItem = projectsTree.`$x`(".//a[normalize-space()='$projectName']")
        projectItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        projectItem.click()

        return this
    }
}