package petstore.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.builders.CreatePet;
import petstore.models.Pet;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PetTests extends BaseTest {
    private final String PET_URL = "/pet";
    private final String FIND_BY_STATUS_URL = "/pet/findByStatus";
    private final String FIND_BY_TAGS_URL = "/pet/findByTags";
    private final String PET_BY_ID_URL = "/pet/{petId}";
    private final String UPLOAD_IMAGE_URL = "/pet/{petId}/uploadImage";


    @Test(description = "")
    public void testPetCreation(){
        Pet pet = CreatePet.createThePet();
        Response response = given().filter(new AllureRestAssured())
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(pet))
                .post(getBaseUri() + PET_URL);
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertEquals(response.jsonPath().getInt("id") , pet.getId());
        Assert.assertEquals(response.getBody().path("name"),pet.getName());
        Assert.assertEquals(response.getBody().path("status") ,pet.getStatus());
        Assert.assertEquals(response.getBody().path("category.id") ,pet.getCategory().getId());
        Assert.assertEquals(response.getBody().path("category.name") ,pet.getCategory().getName());
        Assert.assertEquals(response.getBody().path("photoUrls") ,pet.getPhotoUrls());
        Assert.assertEquals(response.getBody().path("tags[0].id") ,pet.getTags().get(0).getId());
        Assert.assertEquals(response.getBody().path("tags[0].name") ,pet.getTags().get(0).getName());
    }

    @Test(description = "")
    public void testPetAvailability(){
        Pet pet = CreatePet.createThePet();
        String status = "status";

        Response response = given().filter(new AllureRestAssured())
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(pet))
                .post(getBaseUri() + PET_URL);
        Response availabilityResponse = given().filter(new AllureRestAssured())
                .queryParam(status,pet.getStatus()).get(getBaseUri() + FIND_BY_STATUS_URL);
        Assert.assertEquals(HttpStatus.SC_OK, availabilityResponse.statusCode());
        Assert.assertEquals(pet.getStatus(),availabilityResponse.jsonPath().getString("[0].status"));
    }

    @Test(description = "")
    public void getPetById()
    {
        String id = "1";
        Response response = given().filter(new AllureRestAssured())
                .get(getBaseUri() + PET_BY_ID_URL.replace("{petId}", id));
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertEquals(response.jsonPath().getInt("id") , Integer.parseInt(id));
        Assert.assertTrue(response.getBody().path("name") instanceof String);
        Assert.assertTrue(response.getBody().path("status") instanceof String);
        Assert.assertTrue(response.getBody().path("category.id") instanceof Integer);
        Assert.assertTrue(response.getBody().path("category.name") instanceof String);
        Assert.assertTrue(response.getBody().path("photoUrls") instanceof ArrayList);
        Assert.assertTrue(response.getBody().path("tags[0].id") instanceof Integer);
        Assert.assertTrue(response.getBody().path("tags[0].name") instanceof String);
    }

    @Test(description = "")
    public void testUpdateExistingPet() {
        int newPetId=2;
        Pet pet = CreatePet.createThePet();
        Response response = given().filter(new AllureRestAssured())
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(pet))
                .post(getBaseUri() + PET_URL);
        pet.setId(newPetId);
        Response updatedResponse = given().filter(new AllureRestAssured())
                .headers(HttpHeaders.CONTENT_TYPE, getContentType())
                .body(pojoToJson(pet))
                .put(getBaseUri() + PET_URL);
        Assert.assertEquals(updatedResponse.jsonPath().getInt("id") , newPetId);
        Assert.assertNotEquals(updatedResponse.jsonPath().getInt("id") , response.jsonPath().getInt("id"));


    }

}
