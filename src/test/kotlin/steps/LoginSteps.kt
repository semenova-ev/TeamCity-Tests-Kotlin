package steps

import com.codeborne.selenide.Condition.exist
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.open
import io.qameta.allure.Allure
import io.qameta.allure.Step
import pages.LoginPage
import java.time.Duration

class LoginSteps : LoginPage() {

    @Step("Open login page")
    fun openLoginPage() : LoginSteps {
            open("/login.html")
            headerTitle.shouldHave(text("Log in to TeamCity"))
        return this
    }

    @Step("Click on continue with username/password link")
    fun clickLoginByUserPass() : LoginSteps {
        if (continueWithUsernameLink.exists()) {
            continueWithUsernameLink.click()
        }
        usernameInput.should(exist, Duration.ofSeconds(10))
        return this
    }

    @Step("Enter username '{username}'")
    fun setUsername(username : String) : LoginSteps {
        usernameInput.setValue(username)
        return this
    }

    @Step("Enter password '{password}'")
    fun setPassword(password : String) : LoginSteps {
        passwordInput.setValue(password)
        return this
    }

    @Step("Click on Login button")
    fun clickLoginButton() : LoginSteps {
        loginButton.click()
        return this
    }
}