package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(xpath = "//button")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@contains(text(), 'Sign Up Here)]")
    private WebElement signUpLink;

    //7:33 mins - 18.7 Intro to PageObjectModel in Selenium

    public void login(String username, String password) {
        usernameTxtBox.sendKeys(username);
        passwordTxtBox.sendKeys(password);
        loginBtn.click();
    }

    public void clickSignUpBtn() {
        signUpLink.click();
    }
}
