package utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class restassuredUtility {

    public static Response getRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }


    // Static method to make a GET request
    public static Response get(String endpoint) {
        return RestAssured.get(endpoint);
    }

    // Static method to make a POST request
    public static Response post(String endpoint, Object requestBody) {
        return RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post(endpoint);
    }

    // Static method to extract a specific value from the response
    public static String extractValueFromResponse(Response response, String jsonPath) {
        return response.then()
                .extract()
                .path(jsonPath);
    }

    // Add more helper methods as needed

    // Example method to check if a response contains a specific value
    public static boolean responseContainsValue(Response response, String value) {
        return response.getBody().asString().contains(value);
    }



}

