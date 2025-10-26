package dataApi;

public class DataApi {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";
    //Залогиниться
    public static final String COURIER_LOGIN = "/api/v1/courier/login";
    //Создать заказ
    public static final String ORDERCREATE = "/api/v1/orders";
    //Создать курьера
    public static final String PATHCREATE = "/api/v1/courier";
    //Удалить курьера
    public static final String COURIER_DELETE = "/api/v1/courier/%s";
    //Получить список заказов
    public static final String LIST_ORDER_GET = "/api/v1/orders?limit=10&page=0";
}
