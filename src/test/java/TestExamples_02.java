import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestExamples_02 {

    public TestExamples_02() {
        baseURI = "https://reqres.in/api/";
    }

    @Test(priority = 1)
    public void cucumber_01() {
        given()
                .get("users?page=2")
                .then()
                .statusCode(200)
                .body("data[3].first_name", equalTo("Byron"))
                .log().all()
        ;
    }
}
