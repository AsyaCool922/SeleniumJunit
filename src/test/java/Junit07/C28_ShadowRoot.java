package Junit07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C28_ShadowRoot {
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }
    @Test
    public void test(){
        driver.get("https://www.teknosa.com/");

        // Kabul Et düğmesini bulmak için JavaScriptExecutor'u ve özel bir kütüphane olan "selenium-shadow-dom" kullanarak
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement acceptButton = (WebElement) js.executeScript("return document.querySelector('efilli-layout-dynamic').shadowRoot.querySelector(\"div[data-name='Accept Button']\")");

        // Kabul Et düğmesine tıkla
        acceptButton.click();

        WebElement tamam = driver.findElement(By.xpath("//div[starts-with(@id,'ins-ed')]"));
        tamam.click();
    }
}
