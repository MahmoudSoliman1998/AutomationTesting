package api.tests;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PHPTRAVELS_FirstRequest {
    @Test
    public void userSignUp()
    {
        List<List<Object>> formParams = Arrays.asList(
                Arrays.asList("firstname","Mahmoud"),
                Arrays.asList("lastname","Soliman"),
                Arrays.asList("phone","01116226576"),
                Arrays.asList("email","test123@test.com"),
                Arrays.asList("password","123456789"),
                Arrays.asList("confirmPassword","123456789")
                );
        DriverFactory.getAPIDriver("https://phptravels.net/")
                .buildNewRequest("account/signup", RestActions.RequestType.POST)
                .setTargetStatusCode(200)
                .setParameters(formParams, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .performRequest();
    }
}
