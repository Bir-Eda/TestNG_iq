package excelDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EbayDataProvider {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

    }
// data provider birden fazla useri kaydetmemize yarayan metod
    @Test(dataProvider = "getData")
    public void ebayTest(String firstname, String lastname, String email, String password){
    driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
   driver.findElement(By.id("lastname")).sendKeys(lastname);
   driver.findElement(By.id("email")).sendKeys(email);
   driver.findElement(By.id("PASSWORD")).sendKeys(password);
    driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();

    }
    @DataProvider

    public Object [][] getData(){
       Object [][]data={{"vahit", "celebi","vahit@gmail.com", "2847hfg"},
               {"ali", "kadi","ali@gmail.com","19j75h"}};

       return data;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
