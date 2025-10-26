import io.restassured.RestAssured;
import model.CourierModel;
import org.junit.After;
import org.junit.Before;

import static actions.ActionCreateCourier.createCourier;
import static actions.ActionDeleteCourier.courierApiDelete;
import static actions.ActionGetIdCourier.getApiLogin;
import static data.TestData.*;
import static dataApi.DataApi.BASE_URL;

public class BaseTestWithCourier {

    private String courierID;
    private CourierModel courier;

    @Before //создание курьера
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
        createCourier(courier);
    }

    @After  //получаем ID курьера и удаляем запись
    public void courierDelete() {
        this.courierID = getApiLogin(courier).jsonPath().getString("id");
        courierApiDelete(this.courierID);

    }
}
