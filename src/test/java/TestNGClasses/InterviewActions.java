package TestNGClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class InterviewActions extends InterviewBase {
    Actions act;
    @Test
    public void dragAndDrop(){
        driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
        act=new Actions(driver);
        act.dragAndDrop(driver.findElement(By.id("column-a")),driver.findElement(By.id("column-b"))).build().perform();
    }

    @Test
    public void hoverOver(){
        driver.findElement(By.xpath("//a[text()='Hovers']")).click();
        act.moveToElement(driver.findElement(By.id("(//div[@id='content']//img)[position()=3]"))).build().perform();

    }








}
