package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
    @Test
    public void test01() {

        String url="https://restful-booker.herokuapp.com/booking";

       Response response= given().when().get(url);
        //end point'e gondermek icin request olusturmus olduk.
        // Response response --> api tarafindan bize donen cevap olmus oluyor
       Response response1= given().auth().basic("user","password").when().get(url); //-> basic aut ile request gondermk icin

     //   response.prettyPrint(); //response'daki bady'yi yazdirir
      //  response.prettyPeek(); //response'daki herşeyi yazdirir'
        response.peek(); //String olarak datayi verir
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.statusLine());

        //1-Junit assert'leri ile API testi yapabiliriz
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        //2-assertthat ile
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine("application/json; charset=utf-8");

    }
}
