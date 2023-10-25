package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.utils.MockData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    MockData data = new MockData();

    @FindBy(id = "title")
    private WebElement titleDropDown;

    @FindBy(id = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//label[@for='male']//input")
    private WebElement genderM;

    @FindBy(xpath = "//label[@for='female']//input")
    private WebElement genderF;

    @FindBy(id = "dob")
    private WebElement dobTxt;

    @FindBy(id = "ssn")
    private WebElement ssnTxt;

    @FindBy(id = "emailAddress")
    private WebElement emailAddressTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-flat m-b-30 m-t-30']")
    private WebElement registerBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id = "address")
    private WebElement addressTxt;

    @FindBy(id = "locality")
    private WebElement localityTxt;

    @FindBy(id = "region")
    private WebElement regionTxt;

    @FindBy(id = "postalCode")
    private WebElement postalCodeTxt;

    @FindBy(id = "country")
    private WebElement countryTxt;

    @FindBy(id = "homePhone")
    private WebElement homePhoneTxt;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhoneTxt;

    @FindBy(id = "workPhone")
    private WebElement workPhoneTxt;

    @FindBy(id = "agree-terms")
    private WebElement agreeTermsCheckbox;

    @FindBy(xpath = "//div[@class = 'sufee-alert alert with-close alert-success alert-dismissible fade show']")
    private WebElement infoMessageLabel;
    //String title, String firstName, String lastName,
    //                                        String gender, String dob, String password, String address,
    //                                        String locality, String region, String postalCode, String country,
    //                                        String homePhone, String mobilePhone, String workPhone)
    public void fillOutRegistrationPage(List<Map<String, String>> registrationPageTestDataListOfMap) {

        Select titleSelect = new Select(titleDropDown);

        Map<String, String> firstRow = registrationPageTestDataListOfMap.get(0);
        titleSelect.selectByVisibleText(firstRow.get("title"));

        firstNameTextBox.sendKeys(firstRow.get("firstName"));
        lastNameTextBox.sendKeys(firstRow.get("lastName"));

        if(firstRow.get("gender").equalsIgnoreCase("M")){
            genderM.click();
        } else if (firstRow.get("gender").equalsIgnoreCase("F")) {
            genderF.click();
        } else {
            System.out.println("LAGABATQ BBQ");
        }

        dobTxt.sendKeys(firstRow.get("dob"));

        ssnTxt.sendKeys(data.generateRandomSSN());

        Map<String, String> mockNameAndEmail = data.generateRandomNameAndEmail();

        emailAddressTxt.sendKeys(mockNameAndEmail.get("email"));

        passwordTxt.sendKeys(firstRow.get("password"));
        confirmPasswordTxt.sendKeys(firstRow.get("password"));

        nextButton.click();


        addressTxt.sendKeys(firstRow.get("address"));
        localityTxt.sendKeys(firstRow.get("locality"));
        regionTxt.sendKeys(firstRow.get("region"));
        postalCodeTxt.sendKeys(firstRow.get("postalCode"));
        countryTxt.sendKeys(firstRow.get("country"));
        homePhoneTxt.sendKeys(firstRow.get("homePhone"));
        mobilePhoneTxt.sendKeys(firstRow.get("mobilePhone"));
        workPhoneTxt.sendKeys(firstRow.get("workPhone"));

        agreeTermsCheckbox.click();
        registerBtn.click();

    }

    public String getMessage(){
        return infoMessageLabel.getText().substring(0, infoMessageLabel.getText().lastIndexOf(".") + 1);
    }

}
