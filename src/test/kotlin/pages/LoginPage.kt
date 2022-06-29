package pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$x`


open class LoginPage {
    protected val headerTitle = `$x`("//h1[@id='header']")
    protected val continueWithUsernameLink = `$x`("//div[@id='loginPasswordSwitch']//a[text()='continue with username/password']")
    protected val usernameInput = `$x`("//input[@id='username']")
    protected val passwordInput = `$x`("//input[@id='password']")
    protected val loginButton = `$x`("//input[@name='submitLogin']")
}