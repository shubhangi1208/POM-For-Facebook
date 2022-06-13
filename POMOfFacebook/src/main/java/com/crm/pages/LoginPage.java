package com.crm.pages;
import com.crm.base.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory -Obeject Repository:
    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement login;

    //created own xpath of facebook logo
    @FindBy(xpath = "//img[contains(@class,'_97vu img')]")
    WebElement facebookLogo;

    @FindBy(xpath = "//div[@class ='j83agx80 l9j0dhe7']")
    WebElement dropDown;

    @FindBy(xpath = "//div[@class ='qzhwtbm6 knvmm38d']")
    WebElement logOut;

    //Initializing Page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateFbImage() {
        return facebookLogo.isDisplayed();
    }

    public HomePage login(String eid, String pwd) {
        email.sendKeys(eid);
        password.sendKeys(pwd);
        login.click();

        return new HomePage();
    }

    public void logOut(){
        dropDown.click();
        logOut.click();
    }
}
