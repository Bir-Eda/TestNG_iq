package TestNGClasses;

import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.*;

public class TestNGBasics {

    @BeforeSuite
    public void setUp(){
        System.out.println("driver manager is installed");
    }
    @BeforeTest
    public void launchBrowser(){
        System.out.println("Launch chrome browser");
        // WebDriver driver=new ChromeDriver();
    }

    @BeforeClass
    public void login(){
        System.out.println("click to browser");
    }

    @BeforeMethod  // @BeforeEach  in Junit
    public void enterUrl(){
        System.out.println("enter Url");  // enter url iki kere yazacak iki testimiz oldugu icin
       //driver.get("https://google.com")
    }
    @Test  // iki testimiz oldugu icin before metod ve after metodu iki kere yazacak
    public void googleTitleTest(){  // bes testimiz olsaydi bes kerede beforetest ve aftertest yazacakti
        System.out.println("Google Title Test");
    }
    @Test
    public void googleLogo(){
        System.out.println("Google Logo Test");

    }

    @AfterMethod    // @AfterEach  in Junit
    public void refresh(){
        System.out.println("Refreshing the Google home page");
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("Close the browser");
    }
    @AfterTest
    public void deleteAllCookies(){
        System.out.println("delete all cookies");
    }


    @AfterSuite
    public void generateTestReports(){
        System.out.println("generating the google home page");
    }

}
