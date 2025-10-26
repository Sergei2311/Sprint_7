import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.Test;

import static actions.ActionCreateCourier.createCourier;
import static data.TestData.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.apache.http.HttpStatus.*;

public class CreateCourierTest extends BaseTest {

   private CourierModel courier;

    @Test
    @DisplayName("Create courier")
    @Step("Создание курьера  API")
    public void createCourierApiTest() {
    courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);

    createCourier(this.courier)
                .then()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));

    }
}
