package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;

public class GMIBank01 extends GMIBankBaseUrl {

    /*
http://www.gmibank.com/api/tp-customers end point'ine
request gönderin
 1) Tüm Customer bilgilerini ekrana yazdırın.
 2) Tüm Customer SSN lerini ekrana yazdırın.
 3) Tüm Customer SSN lerini text dosyası olarak kaydedin
 4) Olusturduğunuz text dosyasından  SSNleri okuyarak
    "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın
 */

    @Test
    public void test01() {
        spec01.pathParam("first","tp-customers");

        Response response = given()
                .headers("Authorization", "Bearer " + generateToken()).contentType(ContentType.JSON)
                .spec(spec01).when()
                .get("/{first}");
        response.prettyPrint();
    }
}
