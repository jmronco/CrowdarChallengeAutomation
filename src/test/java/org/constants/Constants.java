package org.constants;

public class Constants {
    private Constants() {}
    //URL
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String INVENTORY_URL = BASE_URL + "inventory.html";
    public static final String DEPARTMENTS_URL = "https://www.mercadolibre.com.ar/menu/departments";
    //CREDENTIALS
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String LOCKED_USER = "locked_out_user";
    //ERROR MESSAGES
    //public static final String LOCKED_USER_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out."; //VALOR ORIGINAL
    public static final String LOCKED_USER_ERROR_MESSAGE = "cannot log with this user"; //valor para que la prueba falle
    //TIMEOUTS
    public static final int EXPLICIT_WAIT = 10;
    //HTTP CODES
    public static final int HTTP_OK = 200;


}
