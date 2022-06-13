package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'John Smith')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Find Friends')]")
    WebElement findFriendsLabel;

    @FindBy(xpath = "//span[contains(text(),'Find Friends')]")
    WebElement findFriendsLink;
    @FindBy(xpath = "//body/div[@id='mount_0_0_nU']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/div[1]/a[1]/div[1]")
    WebElement watchLabel;

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){

        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }
    public FindFriends clickOnFriendsLink(){
        findFriendsLink.click();
        return new FindFriends();
    }


    public WatchPage clickOnWatchLink(){
        watchLabel.click();
        return new WatchPage();
    }




}
