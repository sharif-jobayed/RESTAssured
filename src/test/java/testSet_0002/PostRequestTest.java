package testSet_0002;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PostRequestTest {

    private PostBuilder post0001 = new PostBuilder(
            1,
            101,
            "About REST Assured POST",
            "With REST Assured, you can send a POST request by including a body payload in the request."
    );

    @Test
    public void createPostTest() {

        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-type", "application/json")
//                .body("{" +
//                        "   \"userId\": 10, \n    " +
//                        "   \"id\": 50, \n   " +
//                        "   \"title\": \"A demo title\", \n    " +
//                        "   \"body\": \"With REST Assured, you can send a POST request by including a body payload in the request.\"    "+
//                        "}")
//                .body(post0001.buildThePost())
                .body(this.post0001)

            .when()
                .post("posts/")

            .then()
                .statusCode(201)
                .body("title.length()", greaterThan(3))
                .body("title", containsString("About"))
                .body("body", notNullValue())
                .body("body", containsString("you can"))
                .body("id", is(101))

        ;
    }

}
