package com.dulskyiivan.project.api;

import com.dulskyiivan.project.pojo.Product;
import com.dulskyiivan.project.pojo.ProductsResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void verifyGetProducts() {
        ProductsResponse productsResponse = RestAssured.given()
                .filter(new AllureRestAssured())
                .baseUri("https://automationexercise.com/")
                .accept(ContentType.JSON)
                .when()
                .get("/api/productsList")
                .then()
                .statusCode(200)
                .extract()
                .as(ProductsResponse.class, ObjectMapperType.JACKSON_2);


        Product product = productsResponse.getProducts().getFirst();
        Assertions.assertEquals("Blue Top", product.getName());
        Assertions.assertEquals(34, productsResponse.getProducts().size());
        Assertions.assertEquals(200, productsResponse.getResponseCode());

    }

}
