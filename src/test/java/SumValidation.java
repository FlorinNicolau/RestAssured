import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static files.payload.coursePrice;
import static files.reusableMethods.rawToJson;
import static org.assertj.core.api.Assertions.assertThat;

public class SumValidation {

    @Test
    public void sumPrices() {
        JsonPath jsonResponse = rawToJson(coursePrice());
        int count = jsonResponse.getInt("courses.size()");
        Integer sumOfPrices = 0;
        for(int i =0; i < count; i++) {
            Integer coursePrice = jsonResponse.get("courses[" + i + "].price");
            Integer coursesSold = jsonResponse.get("courses[" + i + "].copies");
            sumOfPrices += coursePrice*coursesSold;
        }
        System.out.println(sumOfPrices);
        assertThat(sumOfPrices).isEqualTo(jsonResponse.getInt("dashboard.purchaseAmount"));
    }

}
