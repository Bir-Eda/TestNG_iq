package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Methods {
    public static void clickOn(By locator, WebDriver driver){   // driver.findElement(By.xpath("")); ---> WebElement;   (By.xpath(""));--->bu da locator
       driver.findElement(locator).click();
    }

    public static void sendKeysMethod(By locator, WebDriver driver, String value){
        driver.findElement(locator).sendKeys(value);
    }

}
