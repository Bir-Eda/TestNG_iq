package TestNGClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ilhan_Examples_1 {
   WebDriver driver;
    @BeforeMethod
    public  void setUp(){
      // Browseri acmak icin 1.yol
    //   WebDriver driver=new ChromeDriver();
    //  driver.get("https://www.google.com/");


        // Browseri acmak icin 2.yol
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       // driver.get("url");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void example1(){
        // webelement format
        WebElement sendWord= driver.findElement(By.xpath("//*[@name='q']"));
        sendWord.sendKeys("What types of locaters in selenium?");
        // other format
      //  driver.findElement(By.xpath("//*[@name='q']")).sendKeys("What types of locaters in selenium?");;
       // every browser has back, forward and refresh button and we can handle with Navigation class in selenium
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().to("url");


    }
    @Test
    public void iH_BasicAuth(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[text()='Basic Auth']")).click();



    }
    @Test
    public void driverGet() {
        driver.get("url"); // it opens the browser it will wait until whole page is loded
    }
    // iH= internetHero
    @Test
    public void iH_Dropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // single value dropdown
        driver.findElement(By.xpath("//*[text()='Dropdown']")).click();
        WebElement selDropDown=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(selDropDown);
        select.selectByIndex(1);
        //select.selectByVisibleText(" ");
       // select.selectByValue(" ");
        select.isMultiple(); //  boolean value it returns true or false
        // multiple value dropdown menu  select tag i olmzsa optionlari liste atmamiz lazim

//        List<WebElement> list=driver.findElements(By.xpath(" "));
//
//        for (int i = 0; i <list.size() ; i++) {
//            String text=list.get(i).getText();
//            if(text.equals("choise 7")){
//                list.get(i).click();
//                break;
//            }
//
//
//        }

    }
    @Test
    public void iH_JavaScriptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[text()='JavaScript Alerts']")).click();

            // alert accept
//        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
//        Alert alert=driver.switchTo().alert();
//        alert.accept();


            // get alert text
//        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
//        Alert alert=driver.switchTo().alert();
//        String message=driver.switchTo().alert().getText();
//        System.out.println(message);
//        alert.accept();


            // get alert cansel
//        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
//        Alert alert=driver.switchTo().alert();
//        Thread.sleep(3000);
//        alert.dismiss();


            // alert sendkeys
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("I am a JS prompt");
        Thread.sleep(5000);
       // alert2.accept();

    }
    @Test
    public void iH_addElement(){

    }

    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }
    @Test
    public void iH_FileScreenShot() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // File f=()

    }

    @Test
    public void iH_() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
