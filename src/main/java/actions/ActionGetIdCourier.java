package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;

import static io.restassured.RestAssured.given;

public class ActionGetIdCourier {
    public static final String COURIER_LOGIN = "/api/v1/courier/login";

    @Step("Получение ID курьера")
    public static Response getApiLogin(CourierModel courier) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(courier)
                .when()
                .post(COURIER_LOGIN)
                .then()
                .extract()
                .response();

    }
}
