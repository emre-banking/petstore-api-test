package api.endpoints;

/**
 * This class defines the API endpoints for the modules of the Swagger Petstore.
 */

public class Routes {

    //User module
    public static String baseUrl = "https://petstore.swagger.io/v2";
    public static String postUrl = baseUrl + "/user";
    public static String getUrl = baseUrl + "/user/{username}";
    public static String updateUrl = baseUrl + "/user/{username}";
    public static String deleteUrl = baseUrl + "/user/{username}";

}
