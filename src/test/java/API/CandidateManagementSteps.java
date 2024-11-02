package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class CandidateManagementSteps {

    private String token;
    private Response response;

    @Given("I am authenticated on the OrangeHRM API")
    public void i_am_authenticated_on_the_orangehrm_api() {
        // Set base URI
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com";

//        response = RestAssured.given()
//                .contentType(ContentType.URLENC) // Use URL-encoded form data
//                // .formParam("username", "admin") // Replace with your actual username
//                // .formParam("password", "admin123") // Replace with your actual password
//                .get("/web/index.php/auth/login");
//
//        System.out.println("Login Response: " + response.asString());
//
//        // Step 2: Call the validate endpoint to get the token
//        response = RestAssured.given()
//                .contentType(ContentType.URLENC)
//                .formParam("username", "admin") // Replace with your actual username
//                .formParam("password", "admin123") // Replace with your actual password
//                .formParam("_token", "edcb.ozGjhALtXPTp4GU0xbczWhXQhHP0PTaLqsqvMwjZXO4.01mQ5jraareM2S5Grd9yLiexyEW3aVnB_I2bckWxM4XTf_LbQIY3m42uFg") // Adjust cookie name if needed
//                .post("/web/index.php/auth/validate");
//
//        // Debug: Print the validate response
//        System.out.println("Validate Response: " + response.asString());

        // Extract token from the response (adjust the JSON path as needed)
       // token = response.jsonPath().getString("_token"); // Use the correct key
     //   Assert.assertNotNull("Authentication failed, token is null", token);
    }

    @When("I add a new candidate with valid details")
    public void i_add_a_new_candidate_with_valid_details() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Ahmed Test\",\n" +
                "  \"middleName\": \"Test\",\n" +
                "  \"lastName\": \"Test\",\n" +
                "  \"email\": \"employee@gmail.com\",\n" +
                "  \"contactNumber\": null,\n" +
                "  \"keywords\": null,\n" +
                "  \"comment\": null,\n" +
                "  \"dateOfApplication\": \"2024-11-02\",\n" +
                "  \"consentToKeepData\": false\n" +
                "}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "edcb.ozGjhALtXPTp4GU0xbczWhXQhHP0PTaLqsqvMwjZXO4.01mQ5jraareM2S5Grd9yLiexyEW3aVnB_I2bckWxM4XTf_LbQIY3m42uFg") // Use the token in the header
                .body(requestBody)
                .post("/web/index.php/api/v2/recruitment/candidates");

        Assert.assertEquals(201, response.getStatusCode());
    }

    @Then("the candidate is successfully added")
    public void the_candidate_is_successfully_added() {
        String message = response.jsonPath().getString("message");
        Assert.assertEquals("Candidate added successfully", message);
    }

    @When("I delete the candidate with ID 123")
    public void i_delete_the_candidate_with_id_123() {
        int candidateId = 123; // Replace with actual ID

        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .delete("/web/index.php/recruitment/viewCandidates/" + candidateId);

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("the candidate is successfully deleted")
    public void the_candidate_is_successfully_deleted() {
        String message = response.jsonPath().getString("message");
        Assert.assertEquals("Candidate deleted successfully", message);
    }
}
