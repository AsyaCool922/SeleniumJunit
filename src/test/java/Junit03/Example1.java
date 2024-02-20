package Junit03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example1 {
    static WebDriver driver;

    //Goto googlePage:
    //Type "Green Mile" in searchbox and print the number of result
    //Type "Premonition" in searchbox and print the number of result

    @BeforeAll // BeforeAll sadece çalışır bir kez static olmak zorunda
    public static void beforeAllTest(){
        driver=new ChromeDriver();// her classtan önce bir driver obje oluşturulur
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test

    public void test1(){
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.xpath("//textarea[@aria-controls='Alh6id']"));
        searchBox.sendKeys("Green Mile");
        searchBox.sendKeys(Keys.ENTER);
        WebElement result= driver.findElement(By.xpath("//div[@id='result-stats']"));
        String numberOfResult=result.getText().substring(result.getText().indexOf(" "),result.getText().indexOf("son"));
        System.out.println(numberOfResult);

    }
    @AfterAll
    public static void afterAllTest(){
        driver.quit();
        System.out.println("Test tamamen bitti");
    }




}