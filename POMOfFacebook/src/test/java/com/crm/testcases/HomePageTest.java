package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.FindFriends;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.WatchPage;
import com.crm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    FindFriends friendsPage;
    WatchPage watchPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        friendsPage = new FindFriends();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Log in to Facebook");
    }

    @Test(priority=2)
    public void verifyUserNameTest(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }
    @Test(priority=3)
    public void verifyFindFriendsLinkTest(){
        friendsPage = homePage.clickOnFriendsLink();
    }

    @AfterMethod
    public void closeDown() {
        driver.quit();
    }



}
