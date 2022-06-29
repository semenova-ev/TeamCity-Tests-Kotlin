package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class AddTagsDialogPage {
    protected val window = `$x`("//div[@class='ring-dialog-innerContainer']")
    protected val addTagsInput = window.`$x`(".//input[@class='ring-input-input']")
    protected val addTagConfirmButton = `$x`("//button[@data-test='ring-select-toolbar-button']")
    protected val saveButton = window.`$x`(".//button[contains(@class, 'ring-button-primary')]")
}