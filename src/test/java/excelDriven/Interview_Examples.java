package excelDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Interview_Examples {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.thegreenagencies.com/");

    }
    @Test
    public void ddEmployee() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Actions action = new Actions(driver);
        WebElement pim = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b"));
        action.moveToElement(pim).build().perform();
        Thread.sleep(5000);
        WebElement add = driver.findElement(By.linkText("Add Employee"));
        add.click();
        driver.findElement(By.id("firstName")).sendKeys("Orhn");
        driver.findElement(By.id("lastName")).sendKeys("Dmrc");
        String expectedId = driver.findElement(By.cssSelector("#employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();
        String actualId =driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value");
        Assert.assertEquals(actualId,expectedId,"Fail");
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
    }
    @Test
    public void test2(){


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
