import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static files.reusableMethods.rawToJson;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response =
                //all input details
                given().log().all().queryParam("key", "123").header("Content-Type", "application/json")
                        .body(payload.addPlace())
                        // submit the API, resource, http method
                        .when().post("maps/api/place/add/json")
                        //assertion chain
                        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("App"))
                        .header("Server", "Apache/2.4.18 (Ubuntu")
                        //extract, choose what to extract, choose format
                        .extract().response().asString();
        System.out.println(response);

        //converts String to JSON
//        JsonPath js = new JsonPath(response);
        //give path as String (a, a.b, a.b.c)
        String placeId = rawToJson(response).getString("place_id");

        given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
                .body(payload.updatePlace(placeId))
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        String expectedAddress = "Charleston, 23";
        assertThat(rawToJson(getPlaceResponse).getString("address")).isEqualTo(expectedAddress);
        assertThat(rawToJson(getPlaceResponse)).isNotSameAs(null);
    }
}