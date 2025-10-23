import data.BaseTestOrder;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static actions.ActionCreateOrder.createNewOrder;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreateTest extends BaseTestOrder {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final List<String> color;

    public OrderCreateTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] createOrder() {
        return new Object[][]{
                {"Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList("BLACK")},
                {"Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList("GRAY")},
                {"Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList("BLACK", "GRAY")},
                {"Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList()}
        };
    }

    @Test
    @DisplayName("Creating an order with two colors")
    @Step("Проверка заказа с разными цветами")
    public void createOrderTest() {
        OrderModel order = new OrderModel(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);

        createNewOrder(order)
                .then()
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }

}
