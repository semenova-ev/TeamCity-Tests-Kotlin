package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class RerunBuildDialogPage {
    protected val window = `$x`("//div[@id='runBuildDialog']")
    protected val runButton = window.`$x`(".//input[contains(@class, 'submitButton')]")
}