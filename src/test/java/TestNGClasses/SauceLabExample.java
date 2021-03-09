package TestNGClasses;

import commonMethods.Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SauceLabExample {
    WebDriver driver;
    public static final String USERNAME = "1870Nureda."; // username degismeyecegi icin final yapiyoruz      3
    public static final String ACCESS_KEY = "4f22b9da-14fe-4c0c-a22c-f6c8ac7002cd";
    public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    @Parameters({"browser", "version", "platform"})   //  5. step parametre olarak yaziyoruz       4 (xml 4. step)   ve 6.step saucelab.xml`in uzerine gel ve sag tikla ve run yap
    @BeforeMethod  //  Before class yazarsak metodlardan once driveri calistirmazdi
    public void setUp(String br, String vr, String pf) throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

     // driverin yerine remote driver kullanicaz
    // metodun icine String parametre koyucaz (xml dosyasindan calistiracagimiz icin bu parametreleri cagiricaz
        DesiredCapabilities capabilities = new DesiredCapabilities();  //  Bu class platformu, dizayni  sagliyor
        capabilities.setCapability("browserName",br);   //    2
        capabilities.setCapability("version", vr);
        capabilities.setCapability("platform", pf);
        driver = new RemoteWebDriver(new URL(URL), capabilities);  // sauce parallel ve cloud test yapmamizi sagliyo  1



    }
    @Test
    public void googleTest(){
        driver.get("https://google.com/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Google");
    }
    @Test
    public void buffSciLogin(){
        driver.get("https://hr-testing.buffsci.org");
        By login =By.xpath("//*[@class='btn btn-primary']");
        Methods.clickOn(login, driver);
        By username=By.id("email");
        By password = By.id("password");
        By submit = By.xpath("//*[@type='submit']");

        Methods.sendKeysMethod(username, driver, "admin@staging-buffsci.org");
        Methods.sendKeysMethod(password, driver, "admin123test");
        Methods.clickOn(submit, driver);


        // driver.findElement(By.xpath("\"//div[@class='links']/a\""));  //  bu webelementtir.  bunun yerine common method yazicaz
        // driver.findElement(By.xpath("\"//div[@class='links']/a\""));  //  bu webelementtir.
        // (By.xpath("\"//div[@class='links']/a\""));  //  bu locator


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
