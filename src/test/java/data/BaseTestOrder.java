package data;

import io.restassured.RestAssured;
import org.junit.Before;

import static dataApi.DataApi.BASE_URL;

public class BaseTestOrder {
    @Before
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        }
}
