package testSet_0002;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PutRequestTest {

    private PostBuilder post0002 = new PostBuilder(
            1,
            1,
            "A PUT practice",
            "This post is updated using PUT request"
    );

    @Test(priority = 1)
    public void updatePostTest() {
        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-type", "application/json")
                .body(this.post0002)

            .when()
                .put("posts/1")

            .then()
                .statusCode(200)
                .body("userId", is(1))
                .body("id", is(1))
                .body("title.length()", greaterThan(4))
                .body("title", containsString("PUT"))

            ;
    }

}
