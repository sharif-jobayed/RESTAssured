package testSet_0001;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class GetRequestTest {
    public static void main(String[] args) {
        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com/")

            .when()
                .get("posts/1")

            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("body", containsString("quia et suscipit"))
                .header("content-type", equalTo("application/json; charset=utf-8"))

            ;
    }
}
