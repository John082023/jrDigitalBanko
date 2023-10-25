package co.wedevx.digitalbank.automation.ui.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

    public static WebDriver getDriver(){
        if(driver == null){

            String browser = ConfigReader.getPropertiesValues("browser");

            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "headless":
                    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1920, 1080");
                    options.addArguments("disable-extensions");
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*");
                    options.addArguments("--headless");

                    driver = new ChromeDriver(options);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", "screenshot");
        }
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
