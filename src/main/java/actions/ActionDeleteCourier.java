package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static dataApi.DataApi.COURIER_DELETE;
import static io.restassured.RestAssured.given;

public class ActionDeleteCourier {

    @Step("Удаление курьера")
    public static Response courierApiDelete(String courierID) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete(String.format(COURIER_DELETE, courierID));
    }
}

