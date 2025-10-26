package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static dataApi.DataApi.LIST_ORDER_GET;
import static io.restassured.RestAssured.given;

public class OrderSteps {

    @Step("Получение списка заказов")
    public static int gettingListOrders(){
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(LIST_ORDER_GET)
                .then()
                .extract()
                .jsonPath()
                .getInt("size()");
    }
}
