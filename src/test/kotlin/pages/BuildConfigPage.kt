package pages

import com.codeborne.selenide.Selenide.`$x`

open class BuildConfigPage {

    protected val buildStatusArea = `$x`("//div[@class='Build__status--bG']")
    protected val buildStatusCanceled = buildStatusArea.`$x`(".//a[contains(normalize-space(.), 'Canceled')]")
    protected val buildStatusPassed = buildStatusArea.`$x`(".//a[contains(normalize-space(.), 'Tests passed: 1')]")
    protected val buildStatusSuccess = buildStatusArea.`$x`(".//a[contains(normalize-space(), 'Success')]")

    protected val buttonsMenu = `$x`("//div[@class='BuildTypePageHeader__links--TF']")
    protected val runBuildButton = buttonsMenu.`$x`(".//button[@data-test='run-build']")
    protected val dropDownMenuButton = `$x`("//div[@class='Builds__hasParentGrid--fI']//button[contains(@class, 'ActionsDropdown__anchorButton--eT')]")

    protected val buildLoading = `$x`("//span[@data-test-icon='running_green']")
    protected val warningsBlock = `$x`("//div[@class='PagerWarning__warning--My']")
    protected val favoritesOffFastButton = `$x`("//div[contains(@class,'BuildDetails__heading--o4')]//button[contains(@title,'Remove from favorites')]")
    protected val stopBuildFastButton = `$x`("//button[contains(@class, 'Build__stop--VP')]")
    protected val editConfigurationButton = `$x`("//div[@class='BuildTypePageHeader__links--TF']//a[normalize-space()='Edit configuration...']")
    protected val deployButton = buttonsMenu.`$x`(".//button[@title='Deploy']")
    protected val buildsContainer = `$x`("//div[contains(@class, 'BuildDetails__buildContainer--Ez')]")
}