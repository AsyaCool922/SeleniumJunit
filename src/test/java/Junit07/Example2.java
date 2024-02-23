package Junit07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example2 {

    //Goto page https://authenticationtest.com/
    //Click Basic HTTP/NTLM Authentication
    //user: user   pass:pass use authentication
    //verify succes login
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void baseAuto() throws InterruptedException {
        driver.get("https://authenticationtest.com/");
        driver.findElement(By.partialLinkText("HTTP/NTLM Auth")).click();
//        Thread.sleep(2000);
       // driver.switchTo().window("https://user:pass@https://authenticationtest.com/HTTPAuth/");
        driver.get("https://user:pass@authenticationtest.com/HTTPAuth/");
        driver.findElement(By.xpath("//*[.='Login Success']")).getText().contains("Login");

    }

    @AfterAll
    public static void tearDown() {
      driver.quit();



    }

}
