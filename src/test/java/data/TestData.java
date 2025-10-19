package data;

import com.github.javafaker.Faker;

public class TestData {

    public static final String BASEURL = "https://qa-scooter.praktikum-services.ru";
    public static final String COURIER_LOGIN = "/api/v1/courier/login";
    public static final String ORDERCREATE = "/api/v1/orders";

    static Faker user = new Faker();
    public static final String LOGIN = user.regexify("[a-z]{8}");       //user.name().lastName();
    public static final String PASSWORD = user.regexify("[0-9]{4}");
    public static final String FIRSTNAME = user.name().firstName();
}
