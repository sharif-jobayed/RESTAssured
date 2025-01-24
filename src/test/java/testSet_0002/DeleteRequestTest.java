package testSet_0002;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeleteRequestTest {

    private PostBuilder post0003 = new PostBuilder(
            1,
            1,
            "A DELETE request test",
            "This post is to be deleted using the DELETE request"
    );

    @Test(priority = 1)
    public void deletePostTest() {
        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-type", "application/json")
                .body(this.post0003)

            .when()
                .delete("posts/1")

            .then()
                .statusCode(200)
                .body("isEmpty()", is(true))

            ;
    }

}
