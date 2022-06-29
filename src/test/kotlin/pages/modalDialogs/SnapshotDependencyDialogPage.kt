package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class SnapshotDependencyDialogPage {
    protected val window = `$x`("//div[@id='sourceDependenciesDialog']")
    protected val windowHeader = window.`$x`(".//div[@class='dialogHeader']")
    protected val projectsTree = `$x`("//div[contains(@class, 'ProjectsTree__list--K_')]")
    protected val saveButton = window.`$x`(".//input[contains(@class, 'submitButton')]")
}