package pages

import com.codeborne.selenide.Selenide.`$x`

open class BuildPage {
    protected val tabsTitles = `$x`("//div[@class='ring-tabs-autoCollapseContainer']")
    protected val artifactsTab = tabsTitles.`$x`(".//span[normalize-space()='Artifacts']")
    protected val artifactDownloadButton = `$x`("//div[@class='OverviewTab__limitedWidth--lF']//a[@title='Download all (.zip)']")
    protected val pinnedInfoBlock = `$x`("//div[@class='BuildOverviewTab__secondInfoGroup--p1']")
    protected val tagsInfoBlock = `$x`("//div[contains(@class,'TagsList__wrapper--tx')]")
}