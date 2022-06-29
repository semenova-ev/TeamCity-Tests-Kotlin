package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class PinBuildDialogPage {
    protected val window = `$x`("//div[@class='ring-dialog-innerContainer']")
    protected val pinMessageInput = window.`$x`(".//textarea[@class='ring-input-input']")
    protected val pinButton = window.`$x`(".//button[contains(@class,'ring-button-primary')]")
}