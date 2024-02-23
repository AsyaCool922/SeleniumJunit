package CodeChallange;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CH02 {
    /*
driver.navigate() Methodlari
-  driver.navigate( ).to(String Url);  String olarak girilen Url’e gider
-  driver.navigate( ).back ();     Icinde olunan sayfadan, geldigi onceki sayfaya dondurur
-  driver.navigate( ).forward ();   Back ile donulen bir sayfadan tekrar ileri gider
-  driver.navigate( ).refresh ();    Icinde olunan sayfayi yeniler.
    */

    ///*
  /*
  1-Navigate to page: https://www.ikea.com/
    And verify title: contains Welcome
  2-Navigate to page:https://www.ikea.com/global/en/newsroom/
    And verify title: contains "Newsroom"
  3-Navigate back:https://www.ikea.com/
    verify title:contains Welcome
  4-Navigate forward:https://www.ikea.com/global/en/newsroom/
    verify title: contains "Newsroom"
  5-Refresh page:
    verify title: contains "Newsroom"
   */

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.navigate().to("https://www.ikea.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test @Order(1)
    public void testNavigate(){
        String expectedTitle="Welcome";
        String actual=driver.getTitle();
        Assertions.assertTrue(actual.contains(expectedTitle));
    }
    @Test @Order(2)
    public void testNavigate2(){
        driver.navigate().to("https://www.ikea.com/global/en/newsroom/");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Newsroom"));
        driver.navigate().back();
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Welcome"));
        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Newsroom"));
        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Newsroom"));

    }
@AfterAll
    public static void tearDown(){
        driver.quit();
}





}