package Junit07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Example3 {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.automationtesting.in/Frames.html");

    }

    @Test
    public void test(){
        List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
        System.out.println("iframes.size() = " + iframes.size());
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ALi");
        WebElement iframeText=driver.findElement(By.xpath("//h5[.='iFrame Demo']"));
        Assertions.assertTrue(iframeText.getText().contains("Demo"));
        driver.switchTo().defaultContent();

    }

    @Test
    public void test2(){


        driver.findElement(By.linkText("Iframe with in an Iframe")).click();
        driver.switchTo().frame(1);
        WebElement iframeText=driver.findElement(By.xpath("//h5[.='Nested iFrames']"));
        Assertions.assertTrue(iframeText.getText().contains("Nested"));
        driver.switchTo().frame("f1e84bc58e1f98fa9209e0ee9e71314e");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ALi");


    }




}
