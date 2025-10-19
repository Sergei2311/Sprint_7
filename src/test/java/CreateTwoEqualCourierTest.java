import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.Test;

import static actions.ActionCreateCourier.createCourier;
import static data.TestData.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateTwoEqualCourierTest extends BaseTest {

    @Test
    @DisplayName("Create two identical couriers")
    @Step("Создание одинаковых курьеров")
    public void createDoubleCourierTest(){
    CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);

    createCourier(courier);
    createCourier(courier)
                .then()
                .statusCode(409)
                .assertThat().body("message", equalTo("Этот логин уже используется"));
    }

}
