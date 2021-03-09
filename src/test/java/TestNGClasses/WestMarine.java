package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WestMarine {
    WebDriver driver;
    @BeforeMethod
    // @BeforeClass ve AfterClass yazsaydik butun testleri yapip en son kapatacak her test icin ayrica acip kapatmayacak

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.westmarine.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(/*priority = 1*/) // enabled=false yazarsak bu metodu atlar test etmez
    public void westMarine(){
        driver.findElement(By.xpath("//a[contains(@class, 'user-account-menu')]")).click();
        driver.findElement(By.xpath("//*[@id='header_j_username']")).sendKeys("orhan@gmail.com");
        driver.findElement(By.xpath("//*[@id='header_j_password']")).sendKeys("128.3yhdtN");
        driver.findElement(By.xpath("(//*[text()='Sign In'])[2]")).click();

        String message=driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText();
        String expected="There is an error with your email and/or password. Passwords are case-sensitive, must be at least 8 characters and contain one letter and one number.";

        Assert.assertEquals(expected, message, "failure");

    }
}
