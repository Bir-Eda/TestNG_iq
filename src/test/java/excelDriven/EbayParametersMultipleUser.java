package excelDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EbayParametersMultipleUser {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){  // single user
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

    }

    @Test
    public void ebayTest(){
        Xls_Reader reader=new Xls_Reader("/Users/Eda/TestNG_iq/ebay.xlsx");
        // for loop listenin tamamini kullanmak yada yazdirmak icin
        int rows =reader.getRowCount("Ebay1");

        for(int rowNum=2; rowNum<rows; rowNum++){
            String firstname=reader.getCellData("Ebay1", "firstname", rowNum);
            String lastname=reader.getCellData("Ebay1", "lastname", rowNum);
            String email=reader.getCellData("Ebay1","email", rowNum);
            String password=reader.getCellData("Ebay1","password", rowNum);

            driver.findElement(By.xpath("//input[@id='firstname']")).clear();
            driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys(lastname);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("PASSWORD")).clear();
         driver.findElement(By.id("PASSWORD")).sendKeys(password);
         driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();
}
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
