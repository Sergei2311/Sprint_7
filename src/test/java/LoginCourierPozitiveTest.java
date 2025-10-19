import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;
import org.junit.Test;

import static actions.ActionCreateCourier.createCourier;
import static data.TestData.*;
import static io.restassured.RestAssured.given;

public class LoginCourierPozitiveTest extends BaseTest {
    private CourierModel courier;

    @Test
    @DisplayName("Courier authorization_ login and password")
    @Step("Авторизация курьера")
    public void loginCheck() {
        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
        createCourier(courier);

    Response logResponse = given()
            .log().all()
            .baseUri(BASEURL)
            .contentType(ContentType.JSON)
            .body(courier)
            .when()
            .post(COURIER_LOGIN)
            .then()
            .statusCode(200)
            .extract()
            .response();
    }

}