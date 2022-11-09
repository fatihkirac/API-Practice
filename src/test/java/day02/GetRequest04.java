package day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class GetRequest04 {
   /* http://dummy.restapiexample.com/api/v1/employees  url’ine
    GET request’i yolladigimda gelen response’un
    status kodunun 200 ve content type’inin “application/json”
    ve employees sayisinin 24
    ve employee’lerden birinin “Ashton Cox”
    ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.

    */

    @Test
    public void test04() {
        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response=given().when().get(url);

        //status kodunun 200 ve content type’inin “application/json”
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        //employees sayisinin 24
        response.then().assertThat().body("data",hasSize(24),
                "data.employee_name",hasItem("Ashton Cox"),
                "data.employee_age",hasItems(21,61,23));

        //  hasSize() methodu aradıgımız datadan istediğimiz yerde kaç tane oldugunu bize verir.
        //  hasItem() methodu aradıgımız datanın istenen yerde olup olmadıgını verir. Items olursa birden fazla datayı dogrular
    }
}
