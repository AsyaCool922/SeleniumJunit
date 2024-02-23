package CodeChallange;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CH04 {
/*    driver.manage().window( );Method’lari
-  driver.manage().window().maximize();    Browser’i  maximize yapar
-  driver.manage().window().minimize();    Browser’i  minimize yapar
-  driver.manage().window().fullscreen();   Browser’i full screen yapar
-  driver.manage().window().getPosition( );   Browser’in koordinatlarini verir
-  driver.manage().window().getSize( );     Browser’in olculerini verir
-  driver.manage().window().setPosition(new Point ( x:80 , y:0 ) ) ; Browser’i  istenen koordinata tasir
-  driver.manage().window().setSize(new Dimension( 800 , 600 )); Browser’i  istenen olculere getirir. */

        /*
       1- go to https://the-internet.herokuapp.com/geolocation
       2- Before get browser coordinate and write
       3- Click "Where I am buttun"
       4- Get your coordinate write
       5- Then click " See it on Google "
       6- Verify your coordinate in map

        */
        static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void getBrowserCoordinate() throws InterruptedException {
       // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        WebElement lat =driver.findElement(By.xpath("//div[@id='lat-value']"));
        //  wait.until(ExpectedConditions.visibilityOf(lat));
        WebElement longt =driver.findElement(By.xpath("//div[@id='long-value']"));
        //  wait.until(ExpectedConditions.visibilityOf(longt));
        System.out.println("longt.getText() = " + longt.getText());
        System.out.println("lat = " + lat.getText());
        WebElement map= driver.findElement(By.linkText("See it on Google"));
        map.click();
        WebElement actual=driver.findElement(By.xpath("//h2[@class='bwoZTb']"));
        System.out.println(actual.getText());

    }




}
