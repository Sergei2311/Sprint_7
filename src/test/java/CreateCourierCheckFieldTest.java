import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static actions.ActionCreateCourier.createCourier;
import static data.TestData.*;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CreateCourierCheckFieldTest extends BaseTest {
    private final String login;
    private final String password;
    private final String firstName;


    public CreateCourierCheckFieldTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] checkCourier(){
        return new Object[][]{
            {"",PASSWORD,FIRSTNAME},
            {LOGIN,"",FIRSTNAME}
        };
    }

    @Test
    @DisplayName("Checking the login and password fields")
    @Step("Проверка API создание курьера при незаполненых логин или пароль")
    public void checkFieldTest() {
        CourierModel courier = new CourierModel(login, password, firstName);

        createCourier(courier)
                .then()
                .statusCode(400)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

}
