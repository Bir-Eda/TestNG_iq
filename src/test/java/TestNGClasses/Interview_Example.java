package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Interview_Example {
    WebDriver driver;
    @BeforeMethod

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // driver.get("https://google.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

  //  @Test(/*priority = 1*/) // enabled=false yazarsak bu metodu atlar test etmez
    public void AgooogleTitleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        Assert.assertEquals(actualTitle, expectedTitle, "failure");
    }
    @Test
    public void test(){
        
    }


}
