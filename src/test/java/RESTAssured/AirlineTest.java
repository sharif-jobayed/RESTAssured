package RESTAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utils.RESTUtils.performPost;

public class AirlineTest {
    @Test()
    void createAirline() {
        String endpoint = "https://api.instantwebtools.net/v1/airlines";
        String payload = """
                {
                    "_id":"252d3bca-d9bb-476c-9a97-562d685e235c",
                    "name": "Sri Lankan Airways",
                    "country": "Sri Lanka",
                    "logo": "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                    "slogan": "From Sri Lanka",
                    "head_quaters": "Katunayake, Sri Lanka",
                    "website": "www.srilankaaairways.com",
                    "established": "1990"
                }""";

       Response response = performPost(endpoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200, "The request wasn't successful");
    }
}
