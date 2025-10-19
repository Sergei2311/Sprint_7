package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ActionDeleteCourier {
    public static final String COURIER_DELETE = "/api/v1/courier/%s";

    @Step("Удаление курьера")
    public static Response courierApiDelete(String courierID) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete(String.format(COURIER_DELETE, courierID));
    }
}

