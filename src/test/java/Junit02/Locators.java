package Junit02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        driver.navigate().refresh();
        driver.navigate().refresh();
    }
    @Test
    public void locatorID(){
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();
    }

    @Test
    public void locatName(){
        WebElement searchBox=driver.findElement(By.name("field-keywords"));
        searchBox.click();

    }

    @Test
    public void locatClassName(){
        WebElement searchBox=driver.findElement(By.className("hm-icon-label"));
        searchBox.click();
        searchBox.click();
    }

    @Test
    public void locatTagName(){
        driver.navigate().refresh();
        WebElement searchBox=driver.findElement(By.tagName("hm-icon-label"));
        searchBox.click();
        searchBox.click();
    }

    @Test
    public void locatLinkText() throws InterruptedException {
        WebElement link=driver.findElement(By.linkText("Çok Satanlar"));
        link.click();
        Thread.sleep(3000);
        driver.navigate().forward();

    }
    @Test
    public void locatPartialLinkText() throws InterruptedException {
        WebElement link=driver.findElement(By.partialLinkText("Amazon Ayrıcalıkl"));
        link.click();
        Thread.sleep(3000);
        driver.navigate().forward();

    }

    @Test
    public void absolutexPath() {
        WebElement link=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div/div/a[6]"));
        link.click();

        driver.navigate().forward();

    }

    @Test
    public void relativexPath() {
        WebElement link=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div/div/a[6]"));
        link.click();

        driver.navigate().forward();

    }
    @AfterAll
    public static void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
