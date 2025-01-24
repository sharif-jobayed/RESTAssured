package testSet_0002;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetRequestTest {

    @Test(priority = 1)
    public void getPostTest() {
        RestAssured
            .given() // Pre-conditions
                .baseUri("https://jsonplaceholder.typicode.com/")

            .when() // Actions
                .get("posts/1")

            .then() // Assertions
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("title", notNullValue())
                .body("title", is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("title", containsString("provident occaecati excepturi"))

            ;
    }

}
