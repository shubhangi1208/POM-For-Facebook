package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.ProfilePage;
import com.crm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    TestUtil testUtil;

    public ProfilePageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        testUtil =new TestUtil();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyProfilePageTitleTest() {
        String profilePageTitle = profilePage.verifyProfilePageTitle();
        Assert.assertEquals(profilePageTitle, "Log in to Facebook");
    }

    @Test(priority = 2)
    public void bioDataEntryTest() {
        profilePage.addBioProfile();
    }

    @Test(priority = 3)
    public void checkBioDataEntryTest() {
        profilePage.checkBioDataEntry();
    }

    @AfterMethod
    public void closeDown(){
        driver.quit();
    }
}
