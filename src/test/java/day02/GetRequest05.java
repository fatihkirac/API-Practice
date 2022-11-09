package day02;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {

    /*
    https://www.gmibank.com/api/tp-customers
    bu siteye token ile giris yapalım
     */
    @Test
    public void test05() {
        String url="https://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2Njk5MTg0MTd9.F-VRot4tFLutf4-n0332WFu74ZLblkxPhU5jckH1-3jsh4OQkB1DBVgRGPdSGjp4citHe4BgM6QfiR4LEckLig";

        Response response=given().headers("Authorization","Bearer "+ token).when().get(url);
        response.prettyPrint();
        //token ile doğrulama yaparak gmibank sitesindeki musteri bilgilerini almıs oluyoruz
        // "Bearer " icinde bir bosluk birakiyoruz

        //postmande  url getirildikten sonta Authorization bolumunde Bearer to sekmesine gelip
        // token'ı oraya yapistirarark guvenlik adımını gecip girmis oluyoruz ve musteri bilgileri geliyor.
        //token'ıda swager dan almıs oluyoruz
        //Yukarıda da postmanda yaptigimiz bu islemi kodlarla yapmis olduk
    }
}
