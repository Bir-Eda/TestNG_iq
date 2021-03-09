package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    WebDriver driver;
    @BeforeMethod   // @BeforeClass ve AfterClass yazsaydik butun testleri yapip en son kapatacak her test icin ayrica acip kapatmayacak

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://google.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(/*priority = 1*/) // enabled=false yazarsak bu metodu atlar test etmez
    public void AgooogleTitleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(actualTitle, expectedTitle, "failure");
    }
    @Test(/*priority = 2*/)
    public void CgoogleLogoDisplay(){
        WebElement logo=driver.findElement(By.id("hplogo"));
        System.out.print("logo display situation ==>"+logo.isDisplayed());

    }

    @Test(/*priority = 3*/ dependsOnMethods ="CgoogleLogoDisplay") //
    public void BgmailLogoDisplay(){
        WebElement gmail=driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
        System.out.print("gmail button enabled ==>"+gmail.isEnabled());
    }

}
