package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class InterviewExercise {
    WebDriver driver;
    String baseURL;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

    }
    @Test(priority = 1)
    public void dropDown()throws InterruptedException{
       // driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        Select sel=new Select(driver.findElement(By.id("dropdown")));
        sel.selectByIndex(2);
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void alert()throws InterruptedException{
      //  driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Alert a= driver.switchTo().alert();
        a.dismiss();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void iFrame(){
       // driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        System.out.println(driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText());

    }


    // window handle


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
