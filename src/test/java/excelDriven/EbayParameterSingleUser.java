package excelDriven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class EbayParameterSingleUser {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
    }

    @Test
    public void ebayTest() {
        Xls_Reader reader = new Xls_Reader("/Users/rumeysa/IdeaProjects/git/TestNg_Iq/ebay.xlsx");
        String firstname = reader.getCellData("ebayTest", "firstname", 2);
        System.out.println(firstname);
        String lastname = reader.getCellData("ebayTest", "lastname", 2);
        System.out.println(lastname);
        String email = reader.getCellData("ebayTest", "email", 2);
        System.out.println(email);
        String password = reader.getCellData("ebayTest", "password", 2);
        System.out.println(password);
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("PASSWORD")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}