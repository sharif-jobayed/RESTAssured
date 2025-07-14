package api;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("JSONPlaceholder API Tests")
@Feature("Posts Endpoint")
public class JSONPlaceholderAPITest extends BaseAPITest {

    /*----------------------GET Requests----------------------*/

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

    /*----------------------GET Requests end----------------------*/

}
