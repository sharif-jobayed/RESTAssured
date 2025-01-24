package testSet_0002;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PatchRequestTest {

    private PostBuilder post0004 = new PostBuilder(
            1,
            1,
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "quia et suscipit nsuscipit recusandae consequuntur expedita et cum nreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto"
    );

    @Test(priority = 1)
    public void partiallyUpdatePostTest() {
        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-type", "application/json")
                .body(this.post0004.patchBody("The body is updated via the PATCH request"))

            .when()
                .patch("posts/1")

            .then()
                .statusCode(200)
            ;
    }

}
