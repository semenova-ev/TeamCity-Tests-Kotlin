package api

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import io.restassured.RestAssured.given

class ProjectAPI(private var userToken: String) {
    private lateinit var projectId : String

    fun copyProject(_parentProjectLocator : String, newProjectName : String, newProjectId : String, sourceProjectLocator : String) {
        var parentProjectLocator = _parentProjectLocator
        if (parentProjectLocator.isEmpty()) {
            parentProjectLocator = "_Root"
        }
        this.projectId = newProjectId

        deleteProject()

        val requestBody = "{\"parentProject\":{\"locator\":\"" + parentProjectLocator +
                "\"},\"name\":\"" + newProjectName +
                "\",\"id\":\"" + newProjectId +
                "\",\"copyAllAssociatedSettings\":true,\"sourceProject\":{\"locator\":\"" + sourceProjectLocator + "\"}}"

        given()
            .contentType("application/json")
            .header("Authorization", "Bearer $userToken")
            .body(requestBody)
            .`when`()
            .post(Configuration.baseUrl + "/app/rest/projects/")
            .then().statusCode(200)

    }

    fun deleteProject() {
        deleteProject(this.projectId)
    }

    fun deleteProject(projectId : String) {
        given()
            .header("Authorization", "Bearer $userToken")
            .`when`()
            .delete(Configuration.baseUrl + "/app/rest/projects/id:$projectId")

        Selenide.sleep(5000)
    }

}