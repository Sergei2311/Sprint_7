import data.BaseTestOrder;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import model.OrderModel;
import org.junit.Test;

import java.util.Arrays;

import static data.TestData.ORDERCREATE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class OrderListTest extends BaseTestOrder {
    @Test
    @DisplayName("Response receives a list of orders")
    @Step ("Получение заказа API")
    public void checkListOrders() {

        OrderModel order = new OrderModel("Иван", "Иванов", "Мира,16", "Черкизовская", "89002223311", 2, "2020-10-25", "comment", Arrays.asList("BLACK", "GRAY"));

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(ORDERCREATE)
                .then()
                .log().all()
                .statusCode(201);

        int count = given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/orders?limit=10&page=0")
                .then()
                .extract()
                .jsonPath()
                .getInt("size()");

        assertThat(count, greaterThan(0));

    }
}
