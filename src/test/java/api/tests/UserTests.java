package api.tests;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class contains test methods to verify the functionality of the User module endpoints
 * in the Swagger Petstore API. It utilizes the REST Assured library to send HTTP requests,
 * interacts with the UserEndPoints class to perform CRUD operations, and asserts expected
 * outcomes using TestNG assertions.
 */

public class UserTests {

    Faker faker;
    User userPayload;
    public Logger logger;

    @BeforeClass
    public void setupData()
    {
        faker=new Faker();
        userPayload=new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //logs
        logger= LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser()
    {
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        logger.info("Test Post User executed");

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUserByName()
    {
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        String responseBody = response.getBody().asString();
        response.then().log().all();
        logger.info("Test Get User by Name executed");

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(responseBody.contains(this.userPayload.getUsername()), "Username not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getFirstName()), "Firstname not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getLastName()), "Lastname not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getEmail()), "Email not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getPassword()), "Password not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getPhone()), "Phone not found in response");
    }

    @Test(priority = 3)
    public void testUpdateUserByName()
    {
        //Update
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        logger.info("Test Update User by Name executed");

        Assert.assertEquals(response.getStatusCode(),200);

        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        String responseBody = responseAfterUpdate.getBody().asString();

        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
        Assert.assertTrue(responseBody.contains(this.userPayload.getUsername()), "Username not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getFirstName()), "Firstname not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getLastName()), "Lastname not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getEmail()), "Email not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getPassword()), "Password not found in response");
        Assert.assertTrue(responseBody.contains(this.userPayload.getPhone()), "Phone not found in response");
    }

    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        logger.info("Test Delete User by Name executed");

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
