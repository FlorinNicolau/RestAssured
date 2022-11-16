import files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class DynamicJson {
   private String jsonBody(String isle, String isbn) {
      return "{isle: " + isle +" \r\n" + "isbn: " + isbn +" }" ;
   }

  @Test(dataProvider = "BooksData")
  public void addBook(String isbn, String isle) {
      RestAssured.baseURI = "insert uri here";
      String response = given().log().all().header("header 1", "header value").header("header 2", "header value")
              .body(jsonBody(isle, isbn))
              .when()
              .post("/Library/Addbook.php")
              .then().assertThat().statusCode(200)
              .extract().response().asString();
      JsonPath jsonResponse = reusableMethods.rawToJson(response);
      String id = jsonResponse.get("id");
  }

  //read content of file and convert to Byte data and then String
    //also try https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library
    @Test
    public void addBookDataFromFile() throws IOException {
        RestAssured.baseURI = "insert uri here";
        String response = given().log().all().header("header 1", "header value").header("header 2", "header value")
                .body(new String(Files.readAllBytes(Paths.get("pathTofile"))))
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsonResponse = reusableMethods.rawToJson(response);
        String id = jsonResponse.get("id");
    }



  @DataProvider(name = "BooksData")
    public Object[][] getData() {
      return new Object[][] {
              {"oasdalda", "828"}, {"asadada", "833"}, {"asgeq", "411"}
      };
  }


}
