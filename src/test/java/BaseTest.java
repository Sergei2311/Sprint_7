import io.restassured.RestAssured;
import model.CourierModel;
import org.junit.After;
import org.junit.Before;

import static actions.ActionDeleteCourier.courierApiDelete;
import static actions.ActionGetIdCourier.getApiLogin;
import static data.TestData.*;
import static dataApi.DataApi.BASE_URL;

public class BaseTest {

    private String courierID;
    private CourierModel courier;

    @Before
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
    }

    @After  //получаем ID курьера и удаляем   запись
    public void courierDelete() {
        this.courierID = getApiLogin(courier).jsonPath().getString("id");
        courierApiDelete(this.courierID);
    }
}
