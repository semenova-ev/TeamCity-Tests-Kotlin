package pages

import com.codeborne.selenide.Selenide.`$x`

open class CreateProjectPage {
    protected val contentBlock = `$x`("//div[@id='content']")
    protected val fromRepositoryURLButton = contentBlock.`$x`(".//a[normalize-space()='From a repository URL']")
    protected val parentProjectInput = contentBlock.`$x`(".//input[@id='-ufd-teamcity-ui-parentId']")
    protected val repositoryURL = contentBlock.`$x`(".//input[@name='url']")
    protected val proceedButton = `$x`("//div[@id='container']//input[@type='submit']")
}