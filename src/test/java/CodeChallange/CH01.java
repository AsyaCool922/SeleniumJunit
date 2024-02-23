package CodeChallange;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CH01 {

    /*
    * driver.get() Methodlari
-  driver.get(String Url);     String olarak girilen Url’e gider
-  driver.getTitle();          Icinde olunan sayfanin basligini String olarak getirir
-  driver.getCurrentUrl();     Icinde olunan sayfanin Url’ini String olarak getirir
-  driver.getPageSource();     Icinde olunan sayfanin kaynak kodlarini String olarak getirir */
    /*
    //opening the target website https://www.ikea.com/
    //set expected title contains "Welcome"
    //using getTitle() to retrieve actual title.
    //get currentUrl text
    //get pageSource
     */
    //close driver
  static  WebDriver driver;
    @BeforeAll
    public static void setUp(){
    driver=new ChromeDriver();
    driver.get("https://www.ikea.com/");
    driver.manage().window().maximize();

}
    @Test
    public void testBrowser(){
        String expectedTitle="Welcome"; //beklenen
        String actual=driver.getTitle(); //şuan mevcut
        Assertions.assertTrue(actual.contains(expectedTitle));//true
        Assertions.assertEquals(actual,expectedTitle); //false
        System.out.println("Info WEB:"+driver.getCurrentUrl()+"\n+");//driver.getPageSource());
    }




}