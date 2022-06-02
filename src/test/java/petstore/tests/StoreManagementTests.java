package petstore.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.builders.CreateOrder;
import petstore.models.Order;

import static io.restassured.RestAssured.given;

public class StoreManagementTests extends BaseTest {

    private final String STORE_INVENTORY_URL = "/store/inventory";
    private final String ORDER_URL = "/store/order";
    private final String ORDER_BY_ID_URL = "/store/order/{orderId}";

    @Test(description = "")
    public void testInventory() {
        Response response = given().filter(new AllureRestAssured())
                .get(getBaseUri() + STORE_INVENTORY_URL);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.asString());
        Assert.assertTrue(response.getBody().path("approved") instanceof Integer);
        Assert.assertTrue(response.getBody().path("placed") instanceof Integer);
        Assert.assertTrue(response.getBody().path("delivered") instanceof Integer);
    }

    @Test
    public void testCreateOrder() {
        Order order = CreateOrder.createTheOrder();
        Response response = given().filter(new AllureRestAssured())
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(order))
                .post(getBaseUri() + ORDER_URL);
        System.out.println(response.asString());
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertTrue(response.getBody().path("id") instanceof Integer);
        Assert.assertTrue(response.getBody().path("petId") instanceof Integer);
        Assert.assertTrue(response.getBody().path("quantity") instanceof Integer);
        Assert.assertTrue(response.getBody().path("shipDate") instanceof String);
        Assert.assertTrue(response.getBody().path("status") instanceof String);
        Assert.assertTrue(response.getBody().path("complete") instanceof Boolean);
        Assert.assertEquals(response.getBody().path("id") ,order.getId());
        Assert.assertEquals(response.getBody().path("petId") ,order.getPetId());
        Assert.assertEquals(response.getBody().path("quantity") ,order.getQuantity());
        Assert.assertEquals(response.getBody().path("shipDate") ,order.getShipDate());
        Assert.assertEquals(response.getBody().path("status") ,order.getStatus());
        Assert.assertEquals(response.getBody().path("complete") ,order.isComplete());
    }

}
