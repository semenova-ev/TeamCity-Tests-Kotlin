package pages

import com.codeborne.selenide.Selenide.`$x`

open class AdministrationPage {
    protected val createProjectButton = `$x`("//div[@id='container']//a[normalize-space()='Create project']")
}