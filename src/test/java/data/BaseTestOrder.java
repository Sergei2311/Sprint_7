package data;

import io.restassured.RestAssured;
import org.junit.Before;

import static data.TestData.*;

public class BaseTestOrder {
    @Before
    public void setup() {
        RestAssured.baseURI = BASEURL;
        }
}
