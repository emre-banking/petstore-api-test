package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

/**
 * This class encapsulates the API endpoints and related operations for the User module
 * of the Swagger Petstore. It provides methods to interact with user resources such as
 * creating, reading, updating, and deleting users.
 */

public class UserEndPointsRoutesProperties {


    /**
     * Getting URLs from properties file
     */
    public static ResourceBundle getUrl()
    {
        //Load properties file
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }

    /**
     * Create a new user with the provided payload.
     * @param payload The user data to be created.
     * @return The HTTP response containing the result of the create operation.
     */
    public static Response createUser(User payload)
    {
        String postUrl = getUrl().getString("postUrl");
        Response response =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(postUrl);

        return response;
    }

    /**
     * Read user information based on the provided username.
     * @param userName The username of the user to be read.
     * @return The HTTP response containing the user information.
     */
    public static Response readUser(String userName)
    {
        String getUrl = getUrl().getString("getUrl");
        Response response =
                given()
                        .pathParam("username", userName)
                .when()
                        .get(getUrl);

        return response;
    }

    /**
     * Update user information for the provided username using the given payload.
     * @param userName The username of the user to be updated.
     * @param payload The updated user data.
     * @return The HTTP response containing the result of the update operation.
     */
    public static Response updateUser(String userName, User payload)
    {
        String updateUrl = getUrl().getString("updateUrl");
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .pathParam("username",userName)
                .when()
                        .put(updateUrl);

        return response;
    }

    /**
     * Delete the user with the provided username.
     * @param userName The username of the user to be deleted.
     * @return The HTTP response containing the result of the delete operation.
     */
    public static Response deleteUser(String userName)
    {
        String deleteUrl = getUrl().getString("deleteUrl");
        Response response =
                given()
                        .pathParam("username",userName)
                .when()
                        .delete(deleteUrl);

        return response;
    }
}
