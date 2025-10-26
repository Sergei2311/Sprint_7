package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;

import static dataApi.DataApi.BASE_URL;
import static dataApi.DataApi.COURIER_LOGIN;
import static io.restassured.RestAssured.given;

public class CourierStepLogin {

    @Step("Залогиниться")
    public static Response loginCourier(CourierModel courierModel){

        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(courierModel)
                .when()
                .post(COURIER_LOGIN);
    }
}
