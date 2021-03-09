package excelDriven;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoftAssert{
    So
    @Test
    public void test1(){
        SoftAssert softAssert= new SoftAssert();
        // driver.get("");
        List<String> sehirler=new ArrayList<>(Arrays.asList("Ankara", "Istanbul", "Izmir"));
        for(String s:sehirler){
            softAssert.(sehirler.contains("Rize"), "Message");

        }
        softAssert.assertAll();

    }
}
