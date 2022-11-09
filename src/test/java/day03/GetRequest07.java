package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest07 extends GMIBankBaseUrl {

   /* http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
            “firstName”: “Melva”,
            “lastName”: “Bernhard”,
            “email”: “chas.kuhlman@yahoo.com”
            “zipCode”: “40207"
            “country” “name”: “San Jose”
            “login”: “delilah.metz”

    */

    @Test
    public void test07() {
        //set the url
        spec01.pathParams("first","tp-customers","second",110472);

        //set the expected data

        //send the request and get the response
        Response response = given().spec(spec01).headers("Authorization","Bearer " + generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion

        //1-Matcher ile dogrulama
        response.then().assertThat().body("firstName",equalTo("Melva"),
                "lastName",equalTo("Bernhard"),"email",equalTo("chas.kuhlman@yahoo.com"),
                "zipCode",equalTo("40207"),"country.name",equalTo("San Jose"),
                "user.login",equalTo("delilah.metz"));

        //2-Json ile dogrulama
        JsonPath json=response.jsonPath();
        assertEquals("Melva",json.getString("firstName"));
        assertEquals("Bernhard",json.getString("lastName"));
        assertEquals("chas.kuhlman@yahoo.com",json.getString("email"));
        assertEquals("40207",json.getString("zipCode"));
        assertEquals("San Jose",json.getString("country.name"));
        assertEquals("delilah.metz",json.getString("user.login"));
    }
}
