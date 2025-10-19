package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;

import static io.restassured.RestAssured.given;

public class ActionCreateCourier {

    public static final String PATHCREATE = "/api/v1/courier";

    @Step("Создание курьера _создание курьера")
    public static Response createCourier(CourierModel courierModel) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(courierModel)
                .when()
                .post(PATHCREATE)
                .then()
                .log().all()
                .extract().response();

    }
}
