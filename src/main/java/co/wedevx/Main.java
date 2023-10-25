package co.wedevx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        String name = "John";
//        String reverse = "";
//
//        for(int i = name.length()-1; i >= 0; i--){
//            reverse += name.charAt(i);
//        }
//
//        System.out.println(reverse);
//
//
//        int i = 10;
//        int j = 20;
//
//        i = j + i; //i = 30
//        j = i - j; //j = 10
//        i = i - j; //i = 30 - 20 = 10;
//
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
//
//        String word = "jOhn";
//        boolean vowel = false;
//
//        for(int n = 0; n < word.length(); n++){
//            String letter = String.valueOf(word.charAt(n));
//
//            switch(letter.toLowerCase()){
//                case "a":
//                case "e":
//                case "i":
//                case "o":
//                case "u":
//                    vowel = true;
//                    break;
//            }
//        }
//
//        System.out.println(vowel);
//        System.out.println("---------------------");
//        String doubleChar = "Hi There";
//        String newString = "";
//
//
//        for(int a = 0; a < doubleChar.length(); a++){
//            String eachLetter = String.valueOf(doubleChar.charAt(a));
//
//            newString += eachLetter;
//            doubleChar.substring(0, 1);
//            newString += eachLetter;
//
//        }
//
//        System.out.println(newString);
//        // int indexLetter = eachLetter.indexOf(eachLetter);
//        System.out.println("---------------------");
//
//        int[] nums = {1,2,3,4};
//        int[] nums2 = {};
//
//
//        for(int b = 0; b < nums.length; b++){
//            nums2 = new int[]{nums[b]};
//        }

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'card-block']/h5")));
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.demoblaze.com/index.html");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//        List<WebElement> prices = driver.findElements(By.xpath("//div[@class = 'card-block']/h5"));
//        List<WebElement> products = driver.findElements(By.xpath("//a[@class = 'hrefch']"));
//
//        int max = 0;
//        int counter = 0;
//        String productName;
//        String productWithLargestPrice = "";
//        for(WebElement price : prices){
//
//            String priceToString = price.getText().substring(1);
//            int convertPriceToInteger = Integer.valueOf(priceToString);
//
//            productName = products.get(counter).getText();
//
//            System.out.println(productName + ": " +  price.getText());
//
//            if(convertPriceToInteger > max){
//                max = convertPriceToInteger;
//                productWithLargestPrice = products.get(counter).getText();
//            }
//
//            counter++;
//        }
//
//        System.out.println("---------------------------");
//        System.out.println(productWithLargestPrice + ": $" + max);


//        Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//
//        altPairs("kitten") → "kien"
//        altPairs("Chocolate") → "Chole"
//        altPairs("CodingHorror") → "Congrr"

        int[] arr = {5,5,5,5,2,7};
        boolean counter = false;

        for(int i = 0; i < arr.length -2 ; i++){
            if(arr[i] == arr[i+1] && arr[i] == arr[i+2]){
                System.out.println("TRUE");
            }
        }

        System.out.println(counter);

        // Code challenge of finding first duplicate letter in a string, and then proceeding to ask how I will test that method.

//        driver.findElement(By.id("signin2")).click();
//        driver.findElement(By.id("sign-username")).sendKeys("jaks5");
//        driver.findElement(By.id("sign-password")).sendKeys("jaks2345!");
//        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
//
//        //Thread.sleep(1000);
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();

        //div[@id='signInModal']/div/div/div[3]/button[1]

//        driver.quit();
    }
}