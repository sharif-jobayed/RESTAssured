package api;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("JSONPlaceholder API Tests")
@Feature("Posts Endpoint")
public class JSONPlaceholderAPITest extends BaseAPITest {

    @Test(description = "Get post by ID")
    @Story("Retrieve Post Data")
    @Severity(SeverityLevel.CRITICAL)
    public void getPostByID() {
        given()
                .spec(requestSpec)

        .when()
                .get("/posts/1")

        .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("body", containsString("quia et suscipit"))

        ;
    }

    @Test(description = "Get comments by post ID")
    @Story("Retrieve Comments")
    @Severity(SeverityLevel.NORMAL)
    public void testGetCommentsByPostId() {
        given()
                .spec(requestSpec)
                .queryParam("postId", 1)

        .when()
                .get("/comments")

        .then()
                .statusCode(200)
                .body("", hasSize(greaterThan(0)))
                .body("postId", everyItem(equalTo(1)))
                .body("email", everyItem(containsString("@")))

        ;
    }

}
