package Junit07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Example1 {
    // Goto page
    //1-Click "Show Alert Box button
    //2-Handle warning alert
    //3-Get allert message
    //4-After accept() alert verify "You triggered and handled the alert dialog" text
    //5-Click Show confirm button
    //6-Get allert message
    //7-Dismiss alert
    //8-After dismiss() alert verify "YYou clicked Cancel, confirm returned false." text

    //İki türlü alert var:
                //HTLM ve Javascript
                //Html bizim kendi sitemizde locate edililip handle edilebilir
                //Javascript alert 3 çeşit
                                //Warning: sadece accept()
                                //Confirm accept() veya dismiss()
                                //promt alert sendkeys(), accept(),dismiss()

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

    }
    @Test

    public void testWarning(){

        driver.findElement(By.cssSelector("input[id='alertexamples']")).click();
        String warningMessage=driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        Assertions.assertTrue(driver.findElement(By.id("alertexplanation")).getText().contains("You triggered and "));
    }

    @Test
    public void testConforming(){
        driver.findElement(By.cssSelector("input[id='confirmexample']")).click();
        String confirmMessage=driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        //You clicked Cancel, confirm returned false.
        Assertions.assertTrue(driver.findElement(By.cssSelector("p[id='confirmexplanation']")).getText().contains(" clicked Cancel, confirm"));



}
    @Test
    public void testPromt() throws InterruptedException {
        driver.findElement(By.cssSelector("input[id='promptexample']")).click();
        String promptMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Hello");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
     //   Assertions.assertTrue(driver.findElement(By.cssSelector("//p[.='Hello']")).getText().contains("Hello"));

    }

}