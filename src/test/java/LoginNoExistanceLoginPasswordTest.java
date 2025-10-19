import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static data.TestData.*;
import static data.TestData.BASEURL;
import static data.TestData.COURIER_LOGIN;
import static data.TestData.FIRSTNAME;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LoginNoExistanceLoginPasswordTest {
    private final String login;
    private final String password;
    private final String firstName;

    public LoginNoExistanceLoginPasswordTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] checkCourier() {
        return new Object[][]{
                {"Trlemlsorumm", PASSWORD, FIRSTNAME},
                {LOGIN, "1231231223", FIRSTNAME},
                {"Trlemlsorumm", "1231231223", FIRSTNAME}
        };
    }

    @Test
    @DisplayName("Incorrect login and password")
    @Step("Ввод неверных значений логина и пароля")
    public void checkLogin() {
        CourierModel courier = new CourierModel(login, password, firstName);

        Response logResponse = given()
                .log().all()
                .baseUri(BASEURL)
                .contentType(ContentType.JSON)
                .body(courier)
                .when()
                .post(COURIER_LOGIN)
                .then()
                .statusCode(404)
                .assertThat().body("message", equalTo("Учетная запись не найдена"))
                .extract()
                .response();
    }

}
