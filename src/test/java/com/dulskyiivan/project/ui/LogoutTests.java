package com.dulskyiivan.project.ui;

import com.dulskyiivan.project.pages.LoginPage;
import com.dulskyiivan.project.pages.ProductsPage;
import org.junit.jupiter.api.*;

@DisplayName("Log out")
public class LogoutTests extends BaseTest {


    @BeforeEach
    void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Successful logout")
    public void testSuccessfulLogout() {

        ProductsPage productsPage = new ProductsPage(driver);

        Assertions.assertTrue(productsPage.getBurgerMenuComponent()
                        .clickBurgerMenuButton()
                        .clickLogoutButton()
                        .loginContainerIsDisplayed(),
                "Login container is not displayed after logout!");

    }


    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
