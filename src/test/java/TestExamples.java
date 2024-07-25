import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestExamples {
    public TestExamples() {}

    @Test()
    public void get_01() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status code: "+response.statusCode());
        System.out.println("Content type: " +response.contentType());
        System.out.println("Response body: "+response.getBody().toString());
        System.out.println("Response time: "+response.time());
    }
}
