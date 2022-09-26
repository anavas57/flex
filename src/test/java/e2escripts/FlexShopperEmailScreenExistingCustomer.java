package e2escripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class FlexShopperEmailScreenExistingCustomer {
    private static WebDriver driver;

    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");

        //==============BACKGROUND==================
        /**
         *  GIVEN User wants to log in to the application
         */
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://fmweb.staging.flexint.net/?do=pp3");
        driver.manage().window().setSize(new Dimension(1536, 920));

        /**
         * AND the user is in the pop3 email screen
        */
         driver.switchTo().frame(0);
         driver.switchTo().frame(0);

         //Test Scenario: Existing Customer - User lands in password screen
        /**
         * WHEN The user enters a valid email address
         * AND The user clicks on CONTINUE
         */
        driver.findElement(By.id("email-input")).sendKeys("startdrift@gmail.com");
        driver.findElement(By.id("formSubmitButton")).click();

        /**
         * THEN the user lands on PASSWORD screen
         */
        WebElement password = driver.findElement(By.id("password-input"));
        Assert.assertTrue(password.isDisplayed());
        System.out.println("Password is displayed");
        driver.quit();
    }
}