package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class RemoveBuildDialogPage {
    protected val window = `$x`("//div[@id='stopBuildFormDialog']")
    protected val removeButton = window.`$x`(".//input[contains(@class, 'submitButton')]")
}