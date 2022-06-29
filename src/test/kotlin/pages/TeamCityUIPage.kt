package pages

import com.codeborne.selenide.Selenide.`$x`

open class TeamCityUIPage {
    protected val headerPortal = `$x`("//div[@id='topWrapper']")
    protected val projectsMenuButton = headerPortal.`$x`(".//a[normalize-space()='Projects']")
    protected val administrationMenuButton = headerPortal.`$x`(".//a[normalize-space()='Administration']")
    protected var projectsTree  = `$x`("//div[@class='ReactVirtualized__Grid__innerScrollContainer']")
}