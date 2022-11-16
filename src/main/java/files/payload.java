package files;

public class payload {

    public static String addPlace() {
            return " {\r\n" +
                    "    \"location\" {\r\n" +
                    "        \"lat\": -38.383494, \r\n" +
                    "         \"lng\": 33.427362\r\n" +
                    "          }, \r\n" +
                    "          \"accuracy\": 50,  \r\n" +
                    "            quantityAvailable      \n" +
                    "        }                    \n" +
                    "    }\n" +
                    "}";
    }

    public static String updatePlace(String place) {
        return " {\r\n" +
                "    \"location\" {\r\n" +
                "     \"place_id\": \" " + place + "\", \r\n" +
                "        \"lat\": -38.383494, \r\n" +
                "         \"lng\": 33.427362\r\n" +
                "          }, \r\n" +
                "          \"accuracy\": 50,  \r\n" +
                "            quantityAvailable      \n" +
                "        }                    \n" +
                "    }\n" +
                "}";
    }

    public static String coursePrice() {
        return "{\n" +
                "\"dashboard\" :{\n" +
                "  \"purchaseAmount\" : 910,\n" +
                "  \"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\" : [\n" +
                "  {\n" +
                "    \"title\": \"S Python\",\n" +
                "    \"price\": 50,\n" +
                "    \"copies\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Cypress\",\n" +
                "    \"price\": 40,\n" +
                "    \"copies\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"RPA\",\n" +
                "    \"price\": 45,\n" +
                "    \"copies\": 10\n" +
                "  }  \n" +
                "]\n" +
                "}";
    }

}