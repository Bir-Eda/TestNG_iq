package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Ilhan_Example_2 {
    JavascriptExecutor jse;
    WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        // Browseri acmak icin 1.yol
        //WebDriver driver=new ChromeDriver();
        // driver.get("https://www.google.com/");
        // Browseri acmak icin 2.yol
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // implisit wait
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // explisit wait
       // WebDriverWait wait=new WebDriverWait(driver, 5);
        //WebElement element=driver.findElement(By.xpath(" "));
      //  wait.until(ExpectedConditions.visibilityOf(element));

        // fluent wait
//        Wait <WebDriver>waited = new FluentWait<WebDriver>(driver)
//                .withTimeout(5, TimeUnit.SECONDS).
//                 pollingEvery(100,TimeUnit.MILLISECONDS).
//                 ignoring(NoSuchElementException.class);

    }
    @Test
    public void visibility(){
        boolean searchIconPresence = driver.findElement(By.id("gbqfb")).isDisplayed();
       // boolean searchIconEnabled = driver.findElement(By.id("gbqfb")).isEnabled();
        Assert.assertTrue(searchIconPresence, "Fail");

        WebElement element=driver.findElement(By.xpath(" "));
        element.isSelected();

        boolean result= driver.findElement(By.xpath("  ")).isDisplayed();
        if(result==true){
            System.out.println(result);




        }

    }
    //  isSelected() ornegin radio boxin secilip secilmedigini ortaya cikaran metod boolean deger verir
    //

    @Test
    public void testBasicAuth(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualMessage=driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).getText();
        String expected="Congratulations! You must have the proper credentials.";
       // Assert.assertEquals(actualMessage,expected);​
    }
    @Test
    public void testBuffSci() throws InterruptedException {
        driver.get("https://admin@staging-buffsci.org:admin123test@hr-testing.buffsci.org/login");
        //Thread.sleep(1000);


        // iframe
        WebElement element=driver.findElement(By.xpath(" "));
        driver.switchTo().frame(element);
        driver.switchTo().defaultContent();

        // javascript
//        jse= (JavascriptExecutor) driver;   // driveri javascript e cast ettik
//        jse.executeScript()






    }
            // how to handle authentication pop-up
           // driver.get("https://username:password@buffsi.com/basic_outh");
}