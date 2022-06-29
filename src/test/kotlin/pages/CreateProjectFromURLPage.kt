package pages

import com.codeborne.selenide.Selenide.`$x`

open class CreateProjectFromURLPage {
    protected val proceedButton = `$x`("//div[@id='container']//input[@type='submit']")
    protected val mavenCheckBox = `$x`("//div[@id='discoveredRunners']//input[@id='runnerId']")
    protected val useSelectedButton = `$x`("//div[@id='discoveredRunners']//a[normalize-space()='Use selected']")
    protected val vcsConnectionStatus = `$x`("//form[@id='createProjectForm']//div[@class='connectionSuccessful']")
    protected val resultInfoBlockForNoSettingsProject = `$x`("//main[@id='main-content-tag']//div[contains(@class,'successMessage')]")
    protected val resultInfoBlock = `$x`("//div[@class='editProjectPage']//div[@id='message_objectsCreated']")
}