package com.dulskyiivan.project.api;

import com.dulskyiivan.project.pojo.Brand;
import com.dulskyiivan.project.pojo.BrandsResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrandTest {

    @Test
    public void verifyGetBrands() {
        BrandsResponse brandsResponse = RestAssured.given()
                .filter(new AllureRestAssured())
                .baseUri("https://automationexercise.com/")
                .accept(ContentType.JSON)
                .when()
                .get("/api/brandsList")
                .then()
                .statusCode(200)
                .extract()
                .body().as(BrandsResponse.class, ObjectMapperType.JACKSON_2);

        Brand brand = brandsResponse.getBrands().getFirst();

        Assertions.assertEquals(1, brand.getId());
        Assertions.assertEquals("Polo", brand.getBrand());
        Assertions.assertEquals(34, brandsResponse.getBrands().size());
        Assertions.assertEquals(200, brandsResponse.getResponseCode());
    }

}
