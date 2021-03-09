package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InterviewJavaScriptScrolDown {
    WebDriver driver;

    @BeforeClass

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @Test
    public void scrolDown() throws  InterruptedException{
        driver.get("https://www.edureka.co/blog/java-for-selenium/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement element=driver.findElement(By.cssSelector("span.comments"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true)",element);
        Thread.sleep(2000);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}






















