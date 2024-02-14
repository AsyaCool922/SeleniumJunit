package Junıt01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit1 {
    //@test annotation from junit .we can test without main method

   @Test
    public void test01(){
       //create web driver
        WebDriver driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //go to google address
        driver.get("https://google.com");
       driver.close();

    }

    @Test
    public void test02(){
        //create web driver
        WebDriver driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //go to google address
        driver.get("https://clarusway.com");
        driver.close();

    }
}
