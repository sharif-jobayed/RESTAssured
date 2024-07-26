import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExamples_01 {
    public TestExamples_01() {}

    @Test(priority = 1)
    public void get_01() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Status code: "+response.statusCode());
        System.out.println("Content type: " +response.contentType());
        System.out.println("Response body: "+response.getBody().toString());
        System.out.println("Response time: "+response.time());

        Assert.assertEquals(response.statusCode(), 200, "The response isn't correct");
    }

    @Test(priority = 2)
    public void get_02() {
        Response response = RestAssured.get("https://reqres.in/api/users/2");

        System.out.println("Header content type: "+response.getHeader("content-type"));
        System.out.println("Response cookies: "+response.cookies());
    }
}
