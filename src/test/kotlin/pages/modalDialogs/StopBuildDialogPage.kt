package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class StopBuildDialogPage {
    protected val window = `$x`("//div[@id='stopBuildFormDialog']")
    protected val stopButton = window.`$x`(".//input[contains(@class, 'submitButton')]")
}