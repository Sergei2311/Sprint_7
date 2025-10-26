import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static actions.CourierStepLogin.loginCourier;
import static data.TestData.*;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LoginCourierNegativeTest extends BaseTestWithCourier {
    private final String login;
    private final String password;
    private final String firstName;

    public LoginCourierNegativeTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] checkCourier() {
        return new Object[][]{
                {"", PASSWORD, FIRSTNAME},
                {LOGIN, "", FIRSTNAME},
                {"", "", FIRSTNAME}
        };
    }

    @Test
    @DisplayName("Checking required fields for authorization")
    @Step("Негативный тест. Нельзя залогиниться при отсутствии логина или пароля")
    public void checkLogin() {
        CourierModel courier = new CourierModel(login, password, firstName);

        loginCourier(courier)
                .then()
                .statusCode(SC_BAD_REQUEST)
                .assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .extract()
                .response();
        ;
    }

}
