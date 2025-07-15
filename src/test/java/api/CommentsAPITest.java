package api;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("JSONPlaceholder API Tests")
@Feature("Comments Endpoint")
public class CommentsAPITest extends BaseAPITest {

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

    @Test(description = "Create new comment")
    @Story("Create Comment")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateComment() {
        Comment newComment = new Comment();
        newComment.setPostId(1);
        newComment.setName("Test User");
        newComment.setEmail("test.user@example.com");
        newComment.setBody("This is a test comment created via REST Assured");

        Response response =
        given()
                .spec(requestSpec)
                .body(newComment)

        .when()
                .post("/comments")

        .then()
                .statusCode(201)  // 201 Created
                .body("id", notNullValue())
                .body("postId", equalTo(1))
                .body("name", equalTo("Test User"))
                .body("email", equalTo("test.user@example.com"))
                .body("body", containsString("REST Assured"))
                .extract()
                .response();

        Allure.addAttachment("Request", "application/json",
                "{\"postId\":1,\"name\":\"Test User\",\"email\":\"test.user@example.com\",\"body\":\"This is a test comment created via REST Assured\"}");

        Allure.addAttachment("Response", "application/json", response.asPrettyString());
    }

}
