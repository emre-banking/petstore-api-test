package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * This class encapsulates the API endpoints and related operations for the User module
 * of the Swagger Petstore. It provides methods to interact with user resources such as
 * creating, reading, updating, and deleting users.
 */

public class UserEndPoints {

    /**
     * Create a new user with the provided payload.
     * @param payload The user data to be created.
     * @return The HTTP response containing the result of the create operation.
     */
    public static Response createUser(User payload)
    {
        Response response =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(Routes.postUrl);

        return response;
    }

    /**
     * Read user information based on the provided username.
     * @param userName The username of the user to be read.
     * @return The HTTP response containing the user information.
     */
    public static Response readUser(String userName)
    {
        Response response =
                given()
                        .pathParam("username", userName)
                .when()
                        .get(Routes.getUrl);

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
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .pathParam("username",userName)
                .when()
                        .put(Routes.updateUrl);

        return response;
    }

    /**
     * Delete the user with the provided username.
     * @param userName The username of the user to be deleted.
     * @return The HTTP response containing the result of the delete operation.
     */
    public static Response deleteUser(String userName)
    {
        Response response =
                given()
                        .pathParam("username",userName)
                .when()
                        .delete(Routes.deleteUrl);

        return response;
    }
}
