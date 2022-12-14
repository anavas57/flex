package e2escripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlexShopperPasswordScreenWithInValidPassword {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/veneraserikova/WorkSpace/FlexShopperFramework/src/test/java/resources/drivers/chromedriver");

        /**
         * BACKGROUND:
         * GIVEN User wants to log in to the application
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

        /**
         * AND the user enters the email address of an existing customers
         * AND User clicks on CONTINUE
         * AND User lands on Password screen
         */
        driver.findElement(By.id("email-input")).sendKeys("startdrift@gmail.com");
        driver.findElement(By.id("formSubmitButton")).click();

       /**
        * Test Scenario: Existing Customer can not land in Home Page as loged in user
        * WHEN user enters an invalid password
        */
        driver.findElement(By.id("password-input")).sendKeys("test");

        /**
         * AND user clicks on CONTINUE
         */
        driver.findElement(By.id("formSubmitButton")).click();

        /**
         * THEN the user sees an error message
         */
        // TODO: Capture the error message. It's returning empty now
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Invalid email or password: please check your details and try again']"));
        System.out.println(errorMessage.getText());
        driver.quit();
    }
}
