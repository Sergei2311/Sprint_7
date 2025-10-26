package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.OrderModel;

import static dataApi.DataApi.ORDERCREATE;
import static io.restassured.RestAssured.given;

public class ActionCreateOrder {

    @Step("Создание нового заказа")
    public static Response createNewOrder(OrderModel orderModel) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(orderModel)
                .when()
                .post(ORDERCREATE);

    }

}
