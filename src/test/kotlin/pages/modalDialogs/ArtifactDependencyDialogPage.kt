package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class ArtifactDependencyDialogPage {
    protected val window = `$x`("//div[@id='artifactDependencyFormDialog']")
    protected val windowHeader = window.`$x`(".//div[@class='dialogHeader']")
    protected val selectBuildConfigButton = window.`$x`(".//span[normalize-space()='Select a build configuration']")
    protected val artifactFromArea = `$x`("//div[@class='ReactVirtualized__Grid__innerScrollContainer']")
    protected val artifactRules = window.`$x`(".//textarea[@id='artifactPaths']")
    protected val saveButton = window.`$x`(".//input[contains(@class, 'submitButton')]")
}