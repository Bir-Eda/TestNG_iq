package excelDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Ebay {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

    }

    @Test
    public void ebayTest(){
    WebElement firstName=driver.findElement(By.xpath("//input[@id='firstname']"));
    WebElement lastName=driver.findElement(By.id("lastname"));
    WebElement email=driver.findElement(By.id("email"));
    WebElement password=driver.findElement(By.id("PASSWORD"));
    WebElement creat=driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']"));
        firstName.sendKeys("Birsen");
        lastName.sendKeys("Yildirim");
        email.sendKeys("edanuryildirim@hotmail.com");
        password.sendKeys("123abc.");
        creat.click();


    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
