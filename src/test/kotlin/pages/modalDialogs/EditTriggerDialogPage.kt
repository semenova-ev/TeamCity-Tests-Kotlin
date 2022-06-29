package pages.modalDialogs

import com.codeborne.selenide.Selenide.`$x`

open class EditTriggerDialogPage {
    protected val window = `$x`("//div[@id='editTriggerDialog']")
    protected val windowHeader = window.`$x`(".//div[@class='dialogHeader']")
    protected val triggerComboBox = window.`$x`(".//input[@id='-ufd-teamcity-ui-triggerNameSelector']")
    protected val triggerComboBoxDropDownButton = window.`$x`(".//button[@class='-ufd-teamcity-ui-triggerNameSelector']")
    protected val triggerComboBoxList = `$x`("//div[contains(@class,'list-wrapper-ufd-teamcity-ui-triggerNameSelector')]")
    protected val showAdvancedOptionsButton = window.`$x`(".//a[normalize-space()='Show advanced options']")
    protected val triggerBuildOnChangesCheck = window.`$x`(".//input[@id='watchChangesInDependencies']")
    protected val saveButton = window.`$x`(".//input[@id='editTriggerSubmit']")
}