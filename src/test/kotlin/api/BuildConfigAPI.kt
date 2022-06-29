package api

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import io.restassured.RestAssured.given

class BuildConfigAPI(private var userToken: String) {
    private lateinit var buildConfigurationId : String

    fun copyBuildConfiguration(projectName : String, targetBuildConfigurationId : String, newBuildConfigurationName : String, newBuildConfigurationId : String) {
        this.buildConfigurationId = newBuildConfigurationId

        deleteBuildConfiguration()

        val requestBody = "{\"sourceBuildTypeLocator\":\"" + targetBuildConfigurationId +
                "\",\"name\":\"" + newBuildConfigurationName +
                "\",\"id\":\"" + newBuildConfigurationId +
                "\",\"copyAllAssociatedSettings\":true}"

        given()
            .contentType("application/json")
            .header("Authorization", "Bearer $userToken")
            .body(requestBody)
            .`when`()
            .post(Configuration.baseUrl + "/app/rest/projects/$projectName/buildTypes")
            .then().statusCode(200)
    }

    fun runBuild() {
        val requestBody = "{\"buildType\":{\"id\":\"$buildConfigurationId\"}}"

        given()
            .contentType("application/json")
            .header("Authorization", "Bearer $userToken")
            .body(requestBody)
            .`when`()
            .post(Configuration.baseUrl + "/app/rest/buildQueue")
            .then().statusCode(200)

        Selenide.sleep(5000)
    }

    fun deleteBuildConfiguration() {
        deleteBuildConfiguration(this.buildConfigurationId)
    }

    fun deleteBuildConfiguration(buildConfigId : String) {
        given()
            .header("Authorization", "Bearer $userToken")
            .`when`()
            .delete(Configuration.baseUrl + "/app/rest/buildTypes/$buildConfigId")

        Selenide.sleep(5000)
    }
}