package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;

import static dataApi.DataApi.PATHCREATE;
import static io.restassured.RestAssured.given;

public class ActionCreateCourier {

    @Step("Создание курьера")
    public static Response createCourier(CourierModel courierModel) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(courierModel)
                .when()
                .post(PATHCREATE);

    }
}
