package pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$x`
import org.openqa.selenium.By

open class BuildConfigConfigurationPage {
    protected val runButton = `$x`("//div[@data-hint-container-id='build-configuration-admin-run-button']//button[@class='btn btn_mini runFirstBuild']")
    protected val leftMenuBlock = `$x`("//div[@id='buildTypeTabsContainer']")
    protected val showMoreGeneralSettingsButton = leftMenuBlock.`$x`(".//a[normalize-space()='Show more »']")
    protected val hideUnconfiguredButton = leftMenuBlock.`$x`(".//a[normalize-space()='« Hide unconfigured']")
    protected val dependenciesMenuItem = leftMenuBlock.`$x`(".//a[normalize-space()='Dependencies']")
    protected val triggersMenuItem = leftMenuBlock.`$x`(".//a[normalize-space()='Triggers']")
    protected val mainContentBlock = `$x`("//main[@id='main-content-tag']")
    protected val addNewSnapshotDependencyButton = mainContentBlock.`$x`(".//a[normalize-space()='Add new snapshot dependency']")
    protected val addNewArtifactDependencyButton = mainContentBlock.`$x`(".//a[normalize-space()='Add new artifact dependency']")
    protected val addNewTriggerButton = mainContentBlock.`$x`(".//a[normalize-space()='Add new trigger']")
    protected val snapshotDependenciesUpdatedMessage = `$x`("//div[@id='unprocessed_dependenciesUpdated']")
    protected val artifactDependenciesUpdateMessage = `$x`("//div[@id='unprocessed_artifactDependenciesUpdated']")
    protected val buildTriggerMessage = `$x`("//div[@id='unprocessed_buildTriggersUpdated']")
    protected val snapshotDependenciesTable = `$x`("//table[@id='snapshotDeps']")
    protected val artifactDependenciesTable = `$x`("//table[@id='artifactDeps']")
    protected val triggersTable = `$x`("//table[@id='buildTriggersTable']")
}