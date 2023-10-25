package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CheckingAccountSteps {

    static WebDriver driver;
    static private LoginPage loginPage;

    @BeforeAll
    public static void setup() {

        driver = Driver.getDriver();
        loginPage = new LoginPage(driver);

    }

    @AfterAll
    public static void close() throws InterruptedException {
        Thread.sleep(1200);

    }

    @Given("the user logged in as {string} {string}")
    public void the_user_logged_in_as(String username, String password) {

        driver.get("https://dbank-qa.wedevx.co/bank/login");

        loginPage.login(username, password);

    }

    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> checkingAccountInfoList) {
        driver.findElement(By.id("checking-menu")).click();
        driver.findElement(By.id("new-checking-menu-item")).click();
        String url = "https://dbank-qa.wedevx.co/bank/account/checking-add";
       assertEquals(url, driver.getCurrentUrl());

        NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);
        driver.findElement(By.id(testDataForOneCheckingAccount.getCheckingAccountType())).click();

        driver.findElement(By.id(testDataForOneCheckingAccount.getAccountOwnership())).click();

        driver.findElement(By.id("name")).sendKeys(testDataForOneCheckingAccount.getAccountName());

        driver.findElement(By.id("openingBalance")).sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));

        driver.findElement(By.id("newCheckingSubmit")).click();
    }

    @Then("the user should see the green confirmation {string}")
    public void the_user_should_see_the_green_confirmation(String expectedNMsg) {
        String text = driver.findElement(By.id("new-account-conf-alert")).getText();
        String actual = text.substring(0, text.length() -1).trim();
        System.out.println(actual);
        //expectedNMsg = "Confirmation " + expectedNMsg + "\n×";
        assertEquals(expectedNMsg, actual);
    }

    @Then("the user should see newly added account card")
    public void the_user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {
        driver.findElement(By.id("firstRow"));
        List<WebElement> allFirstRow = driver.findElements(By.xpath("//div[@id = 'firstRow']/div"));
        for (WebElement card : allFirstRow) {
            //System.out.println(card.getText());
        }
    }

    @Then("the user should see the following transactions")
    public void the_user_should_see_the_following_transactions(List<BankTransaction> expectedTransactions) {
        WebElement firstRow = driver.findElement(By.xpath("//table[@id = 'transactionTable']/tbody/tr"));

        List<WebElement> firstRowColumns = firstRow.findElements(By.xpath("td"));

        String actualCategory = firstRowColumns.get(1).getText();
        String actualDescription = firstRowColumns.get(2).getText();
//     String dynamicNumber = actualDescription.substring(0, 9);
//        System.out.println(dynamicNumber);
        double actualAmount = Double.parseDouble(firstRowColumns.get(3).getText().substring(1));
        double actualBalance = Double.valueOf(firstRowColumns.get(4).getText().substring(1));
        System.out.println(actualBalance);

        BankTransaction expectedTransaction = expectedTransactions.get(0);
        assertEquals(expectedTransaction.getCategory(), actualCategory);
        //Assert.assertEquals(expectedTransaction.getDescription(), actualDescription);
        //Assert.assertEquals(expectedTransaction.getAmount(), actualAmount);
        //Assert.assertEquals(expectedTransaction.getBalance(), actualBalance);

    }
}
