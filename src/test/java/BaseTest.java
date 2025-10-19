import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.CourierModel;
import org.junit.After;
import org.junit.Before;

import static actions.ActionDeleteCourier.courierApiDelete;
import static actions.ActionGetIdCourier.getApiLogin;
import static data.TestData.*;

public class BaseTest {

        private String courierID;
    private CourierModel courier;

    @Before
    public void setup() {
        RestAssured.baseURI = BASEURL;
        courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
    }

    @After  //получаем ID курьера и удаляем   запись
    public void courierDelete(){
        this.courierID = getApiLogin(courier).jsonPath().getString("id");
        courierApiDelete(this.courierID);
    }
}
