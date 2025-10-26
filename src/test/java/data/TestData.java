package data;

import com.github.javafaker.Faker;

public class TestData {

    static Faker user = new Faker();
    public static final String LOGIN = user.regexify("[a-z]{8}");       //user.name().lastName();
    public static final String PASSWORD = user.regexify("[0-9]{4}");
    public static final String FIRSTNAME = user.name().firstName();
}
