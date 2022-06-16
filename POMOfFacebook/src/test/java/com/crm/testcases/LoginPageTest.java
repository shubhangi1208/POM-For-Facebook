package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "contacts";
    Logger log = Logger.getLogger("LoginPageTest.class");

    public LoginPageTest() {
        super();// super keyword calls
    }
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        log.info("****************************** Facebook Title *****************************************");
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

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority=4,dataProvider="getCRMTestData")
    public void logintoFacebook(String username, String password){
       loginPage.login(username, password);
    }

    @AfterMethod
    public void closeDown() {
        driver.quit();
    }
}
