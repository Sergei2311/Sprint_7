import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.Test;

import static actions.CourierStepLogin.loginCourier;
import static data.TestData.*;
import static org.apache.http.HttpStatus.*;

public class LoginCourierPozitiveTest extends BaseTestWithCourier {
    CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);

    @Test
    @DisplayName("Courier authorization_ login and password")
    @Step("Авторизация курьера")
    public void loginCheck() {

        loginCourier(courier)
                .then()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

}