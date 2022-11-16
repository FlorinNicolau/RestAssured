package files;

import io.restassured.path.json.JsonPath;

public class reusableMethods {
    public static JsonPath rawToJson(String response) {
        JsonPath jsonResponse = new JsonPath(response);
        return jsonResponse;
    }
}
