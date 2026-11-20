package org.tests;

import org.api.ApiClient;
import org.api.ApiResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.constants.Constants.DEPARTMENTS_URL;
import static org.constants.Constants.HTTP_OK;

public class MercadoLibreApiTests {

    @Test
    public void departmentsServiceReturnsDepartments() {
        ApiResponse response = ApiClient.get(DEPARTMENTS_URL);

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body (primeros 500): "
                + response.body().substring(0, Math.min(500, response.body().length())));

        Assert.assertEquals(response.statusCode(), HTTP_OK, "Status inesperado");
        Assert.assertFalse(response.body().isBlank(), "Body vacío");
        Assert.assertTrue(response.body().toLowerCase().contains("department"),
                "La respuesta no contiene departamentos");
    }
}