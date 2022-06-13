package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'John Smith')]")
    WebElement profileLink;

    @FindBy(xpath = "//span[contains(text(), 'Edit profile')]")
    WebElement editProfileLink;

    //    @FindBy(xpath = "//span[contains(text(), 'Add Bio')]" )
//    @FindBy(xpath = "//div[@aria-label = 'Add Bio')]" )
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]" +
            "/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[2]" +
            "/div[1]/div[1]/span[1]/span[1]")
    WebElement addBioLink;

    @FindBy(xpath = "//textarea[@dir = 'ltr']")
    WebElement addDescriptionLink;

    //    @FindBy(xpath = "//span[contains(text(), 'Save')]" )
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]" +
            "/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]" +
            "/span[1]/span[1]")
    WebElement saveBioLink;

    @FindBy(xpath = "//span[contains(text(),'HI MY NAME IS PRAKASH')]")
    WebElement checkDescriptionLink;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]" +
            "/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]" +
            "/div[2]/div[2]/div[1]/ul[1]/div[2]")
    WebElement checkLocationLink;

    public ProfilePage() {

        PageFactory.initElements(driver, this);
    }
    public void addBioProfile() {
        profileLink.click();
        editProfileLink.click();
        addBioLink.click();
        addDescriptionLink.sendKeys("This is Selinium Project ");
        saveBioLink.click();
    }

    public boolean checkBioDataEntry() {
        profileLink.click();
        return checkDescriptionLink.isDisplayed();
    }

    public String verifyProfilePageTitle() {
        return driver.getTitle();
    }
}
