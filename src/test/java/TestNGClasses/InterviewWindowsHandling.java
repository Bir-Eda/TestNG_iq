package TestNGClasses;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
public class InterviewWindowsHandling {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void iteratorWindowHandling() {
        driver.get("https://www.edureka.co/blog/java-for-selenium/");

        String parentHandle = driver.getWindowHandle();
        System.out.println("parent handle id = " + parentHandle);

        driver.findElement(By.xpath("//a[contains(@class,'fetch-link')]")).click();
        Set<String> handles = driver.getWindowHandles();  // birden fazla pencere oldugu icin
        System.out.println("number of windows " + handles.size());
        Iterator<String> itr = handles.iterator();
        while (itr.hasNext()) {
            String childHandle = itr.next();
            System.out.println("child handle = " + childHandle);
            if (!parentHandle.equals(childHandle)) {
                driver.switchTo().window(childHandle);
                System.out.println(driver.findElement(By.xpath("(//h2[@class='title_box_heading'])[position()=1]")).getText());
            }
        }
    }
    @Test
    public void forLoopWindowHandling(){
        driver.get("https://www.edureka.co/blog/java-for-selenium/");
        String parentHandle = driver.getWindowHandle();
        System.out.println("parent handle id = " + parentHandle);
        String titleParent = driver.getTitle();
        System.out.println(titleParent);
        driver.findElement(By.xpath("//a[contains(@class,'fetch-link')]")).click();
        for (String windowHandle:driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(titleParent)){
                break;
            }
            System.out.println(driver.findElement(By.xpath("(//h2[@class='title_box_heading'])[position()=1]")).getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}