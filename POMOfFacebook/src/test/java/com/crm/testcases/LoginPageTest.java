package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();// super keyword calls
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Log in to Facebook");
    }

    @Test(priority = 2)
    public void fbLogoImageTest() {
        boolean flag = loginPage.validateFbImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void closeDown() {
        driver.quit();
    }
}