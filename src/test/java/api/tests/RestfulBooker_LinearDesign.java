package api.tests;

import com.shaft.api.RequestBuilder;
import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestfulBooker_LinearDesign {
    RestActions apiObject;
    @Test
    public void getBookingIds()
    {
        apiObject = DriverFactory.getAPIDriver("https://restful-booker.herokuapp.com/");
        apiObject.buildNewRequest("booking", RestActions.RequestType.GET).performRequest();
    }
    @Test
    public void getBooking()
    {
        apiObject = DriverFactory.getAPIDriver("https://restful-booker.herokuapp.com/");
        apiObject.buildNewRequest("booking/"+"780", RestActions.RequestType.GET).performRequest();
    }
    @Test
    public void createBooking()
    {
        JSONObject createBookingBody = new JSONObject();
        createBookingBody.put("firstname","Mahmoud");
        createBookingBody.put("lastname","Mahmoud");
        createBookingBody.put("totalprice","1000");
        createBookingBody.put("depositpaid",true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        createBookingBody.put("bookingdates",bookingdates);
        createBookingBody.put("additionalneeds","BreakFast");
        apiObject = DriverFactory.getAPIDriver("https://restful-booker.herokuapp.com/");
        apiObject.buildNewRequest("booking", RestActions.RequestType.POST)
                .setContentType(ContentType.JSON)
                .setRequestBody(createBookingBody)
                .performRequest();
    }
    @Test
    public void updateBooking()
    {
        JSONObject updateBodyContent = new JSONObject();
        updateBodyContent.put("firstname","Mahmoud");
        updateBodyContent.put("lastname","Soliman");
        updateBodyContent.put("totalprice",5000);
        updateBodyContent.put("depositpaid",true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        updateBodyContent.put("bookingdates",bookingdates);
        updateBodyContent.put("additionalneeds","Breakfast");

        apiObject = DriverFactory.getAPIDriver("https://restful-booker.herokuapp.com/");
        apiObject.buildNewRequest("booking/"+"780", RestActions.RequestType.PUT)
                .setContentType(ContentType.JSON)
                .setAuthentication("admin","password123", RequestBuilder.AuthenticationType.BASIC)
                .setRequestBody(updateBodyContent)
                .performRequest();
    }
}
