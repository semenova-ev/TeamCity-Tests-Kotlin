package pages

import com.codeborne.selenide.Selenide.`$x`

open class ProjectPage {
    protected val overviewTab = `$x`("//div[@class='OverviewTab__limitedWidth--lF']")
    protected val showAllConfigurationsButton = `$x`("//div[@class='ShowAllBuildTypes__button--HF']")
    protected val buildChainsTab = `$x`("//div[contains(@class, 'ring-tabs-rendered')]//a[@aria-label='Build Chains']")
    protected val deploySuccessStatus = `$x`("//td[@class='chainStatusText']//a[contains(@class, 'resultsLink')]")
}