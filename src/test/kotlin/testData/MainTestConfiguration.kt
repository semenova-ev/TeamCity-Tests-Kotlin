package testData

import com.codeborne.selenide.Configuration
import steps.LoginSteps

open class MainTestConfiguration {

    companion object {
        private lateinit var userName: String;
        private lateinit var userPass: String;
        private lateinit var userToken: String;

        fun configure() {
            Configuration.baseUrl = "http://51.250.97.59:8111"
            Configuration.browserSize = "1920x1080"

            userName = Users.mainUsername
            userPass = Users.mainUserpass
            userToken = Users.mainUsertoken

            authorisation(
                userName,
                userPass
            )
        }

        private fun authorisation(userName: String, userPassword : String) {
            var loginSteps = LoginSteps()

            loginSteps
                .openLoginPage()
                .clickLoginByUserPass()
                .setUsername(userName)
                .setPassword(userPassword)
                .clickLoginButton()
        }
    }

    fun getUserToken() : String {
        return userToken
    }
}