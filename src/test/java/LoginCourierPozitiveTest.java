import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static data.TestData.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class LoginCourierPozitiveTest extends BaseTestWithCourier {
    String body = String.format("{\"login\": \"%s\", \"password\": \"%s\"}", LOGIN, PASSWORD);

    @Test
    @DisplayName("Courier authorization_ login and password")
    @Step("Авторизация курьера")
    public void loginCheck() {

    given()
            .log().all()
            .baseUri(BASEURL)
            .contentType(ContentType.JSON)
            .body(body)
            .when()
            .post(COURIER_LOGIN)
            .then()
            .statusCode(SC_OK)
            .extract()
            .response();
    }

}