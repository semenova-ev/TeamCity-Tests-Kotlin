package steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.BuildDropdownMenuPage
import java.time.Duration

class BuildDropdownMenuSteps : BuildDropdownMenuPage() {

    @Step("Select Pin menu item")
    fun clickPinItem() : BuildDropdownMenuSteps {
        dropDownMenuPinItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        dropDownMenuPinItem.click()
        return this
    }

    @Step("Select Add tags menu item")
    fun clickAddTagsItem() : BuildDropdownMenuSteps {
        dropDownMenuAddTagsItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        dropDownMenuAddTagsItem.click()
        return this
    }

    @Step("Select Add to favorite menu item")
    fun clickAddToFavoritesItem() : BuildDropdownMenuSteps {
        dropDownMenuAddToFavoritesItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        dropDownMenuAddToFavoritesItem.click()
        return this
    }

    @Step("Select Rerun menu item")
    fun clickReRunItem() : BuildDropdownMenuSteps {
        dropDownMenuReRunItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        dropDownMenuReRunItem.click()
        return this
    }

    @Step("Select Remove menu item")
    fun clickRemoveItem() : BuildDropdownMenuSteps {
        dropDownMenuRemoveItem.shouldBe(Condition.visible, Duration.ofSeconds(30))
        dropDownMenuRemoveItem.click()
        return this
    }
}