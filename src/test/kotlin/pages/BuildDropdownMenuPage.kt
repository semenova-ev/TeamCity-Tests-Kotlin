package pages

import com.codeborne.selenide.Selenide.`$x`

open class BuildDropdownMenuPage {
    protected val dropDownMenu = `$x`("//div[@data-test='ring-popup']")
    protected val dropDownMenuPinItem = dropDownMenu.`$x`(".//span[@title='Pin...']")
    protected val dropDownMenuAddTagsItem = dropDownMenu.`$x`(".//span[@title='Add tags...']")
    protected val dropDownMenuAddToFavoritesItem = dropDownMenu.`$x`(".//span[@title='Add to favorites']")
    protected val dropDownMenuReRunItem = dropDownMenu.`$x`(".//span[normalize-space()='Re-run this build...']")
    protected val dropDownMenuRemoveItem = dropDownMenu.`$x`(".//span[normalize-space()='Remove...']")
}