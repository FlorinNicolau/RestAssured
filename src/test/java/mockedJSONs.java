import io.restassured.path.json.JsonPath;

import static files.reusableMethods.rawToJson;
import static files.payload.*;

public class mockedJSONs {

    public static void main(String[] args) {
       JsonPath jsonResponse = rawToJson(coursePrice());
       //retrieve Array length
       Integer count = jsonResponse.getInt("courses.size()");
        //print purchase amount
       System.out.println(jsonResponse.getInt("dashboard.purchaseAmount"));
       //get title of first course
       String firstTile = jsonResponse.getString("courses[0].title");
       System.out.println(firstTile);
       //iterate through all courses and retrieve titles and prices
       for(int i =0; i < count; i++) {
           String courseTitle = jsonResponse.get("courses[" + i + "].title");
           System.out.println(courseTitle);
           Integer coursePrice = jsonResponse.get("courses[" + i + "].price");
           System.out.println(coursePrice);
       }

        for(int i =0; i < count; i++) {
            String courseTitle = jsonResponse.get("courses[" + i + "].title");
            if(courseTitle.equalsIgnoreCase("RPA")) {
                System.out.println(jsonResponse.get("courses[" + i + "].copies").toString());
                break;
            }
        }
    }
}
