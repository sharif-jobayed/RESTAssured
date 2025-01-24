package testSet_0001;

import io.restassured.RestAssured;

public class HelloRestAssured {
    public static void main(String[] args) {
        RestAssured
            .given()


            .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")

            .then()
                .statusCode(200);
            ;
    }
}
