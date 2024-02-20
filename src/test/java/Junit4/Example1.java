package Junit4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Example1 {
    //Goto webpage http://www.automationpractice.pl/index.php
    //Click sing button
    //enter mail adress without @ sign
    //Verify "Invalid adress
   static WebDriver driver;


    @Test
    public void testemail() throws InterruptedException {
        WebElement sign=driver.findElement(By.xpath("//a[@class='login']"));
        //WebElement sign=driver.findElement(By.xpath("//*[contains(@class,'login')]"));
        //WebElement sign=driver.findElement(By.xpath("//*[startswith(@class,'login')]"));

        sign.click();

        WebElement emailTextArae=driver.findElement(By.xpath("//input[@id='email_create']"));
        emailTextArae.sendKeys("asyacool.gmail");
        emailTextArae.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement invalid= driver.findElement(By.xpath("//*[contains(text(),' email address.')]"));

        Assertions.assertEquals(invalid.getText(),"Invalid email address.");


    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
