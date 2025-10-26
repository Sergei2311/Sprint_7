import data.BaseTestOrder;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.OrderModel;
import org.junit.Test;

import java.util.Arrays;

import static actions.ActionCreateOrder.createNewOrder;
import static actions.OrderSteps.gettingListOrders;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class OrderListTest extends BaseTestOrder {
    @Test
    @DisplayName("Response receives a list of orders")
    @Step("Проверить получение списка заказов")
    public void checkListOrders() {

        OrderModel order = new OrderModel("Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList("BLACK", "GRAY"));

        createNewOrder(order)
                .then()
                .statusCode(SC_CREATED)
                .body("track", notNullValue());

        int count = gettingListOrders();

        assertThat(count, greaterThan(0));

    }
}
