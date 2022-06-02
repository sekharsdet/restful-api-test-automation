package petstore.tests;

import io.restassured.response.Response;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.builders.CreateUser;
import petstore.models.User;

import static io.restassured.RestAssured.given;

public class UserTests extends BaseTest{

    private final String USER_URL = "/user";
    private final String USER_LOGIN_URL = "/user/login";
    private final String USER_LOGOUT_URL = "/user/logout";


    @Test(description = "")
    public void testUserCreation() {
        User user = CreateUser.createTheUser();
        Response response = given()
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(user))
                .post(getBaseUri() + USER_URL);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertTrue(response.getBody().path("id") instanceof Integer);
        Assert.assertTrue(response.getBody().path("username") instanceof String);
        Assert.assertTrue(response.getBody().path("firstName") instanceof String);
        Assert.assertTrue(response.getBody().path("lastName") instanceof String);
        Assert.assertTrue(response.getBody().path("email") instanceof String);
        Assert.assertTrue(response.getBody().path("password") instanceof String);
        Assert.assertTrue(response.getBody().path("phone") instanceof String);
        Assert.assertTrue(response.getBody().path("userStatus") instanceof Integer);
        Assert.assertEquals(response.jsonPath().getInt("id") , user.getId());
        Assert.assertEquals(response.getBody().path("username"),user.getUsername());
        Assert.assertEquals(response.getBody().path("firstName") ,user.getFirstName());
        Assert.assertEquals(response.getBody().path("lastName") ,user.getLastName());
        Assert.assertEquals(response.getBody().path("email") ,user.getEmail());
        Assert.assertEquals(response.getBody().path("password") ,user.getPassword());
        Assert.assertEquals(response.getBody().path("userStatus") ,user.getUserStatus());
    }

    @Test(description = "")
    public void testUserLogin(){
        User user = CreateUser.createTheUser();
        given()
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(user))
                .post(getBaseUri() + USER_URL);
        Response response = given()
                .param("userName", user.getUsername())
                .param("password", user.getPassword())
                .accept(getContentType())
                .get(getBaseUri() + USER_LOGIN_URL);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.asString());
        Assert.assertTrue(response.getBody().asString().contains("Logged in user session: "));
    }

    @Test(description = "")
    public void testUserLogout(){
        // user creation and login is not required for log out scenario
        // The server is not restricting the user login first
        User user = CreateUser.createTheUser();
        given()
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(user))
                .post(getBaseUri() + USER_URL);
        given()
                .param("userName", user.getUsername())
                .param("password", user.getPassword())
                .accept(getContentType())
                .get(getBaseUri() + USER_LOGIN_URL);
        // above two steps are added like in normal case, where user logins first and later logs out
        Response response = given()
                .get(getBaseUri() + USER_LOGOUT_URL);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertTrue(response.getBody().asString().contains("User logged out"));
    }
}
