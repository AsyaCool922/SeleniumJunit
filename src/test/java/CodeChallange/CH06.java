package CodeChallange;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CH06 {
/*    Locators


driver.findElement(Locator);  Tanimladigimiz web elementin yerini driver’in bulabilmesi icin kullanilir

driver.findElement(By.id(String id));
driver.findElement(By.name(String name));
driver.findElement(By.className(String class name));
driver.findElement(By.linkText(String Link));
driver.findElement(By.partialLinkText(String link parcasi));
driver.findElement(By.tagName(String tag name));
driver.findElements(Locator);  Locator degerine uygun Web elementlerinin listesini döndürür
By.xpath(“String”)  //tagName[@attributeIsmi=’attributeValue’]
            //*[text()=’tam metin’]    (relative xpath)
            By.cssSelector(“String”)  TagName[attName=’value’];     tagName#idValue;    .classValue;*/

    /*
1) Open the browser
2) Enter the URL “https://hava-durumu-apps.netlify.app/”
3) Enter Berlin on ınput area
4) Verify result contains Berlin
5) After result locate Degrees of city by using relative locator
6)
   */
    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));


    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://hava-durumu-apps.netlify.app/");
       WebElement sent= driver.findElement(By.xpath("//input[@id='input']"));
       sent.sendKeys("Berlin");

        WebElement city=driver.findElement(By.cssSelector("h2[class='text-2xl font-semibold mb-3']"));
     String result=city.getText();
        assertEquals(result,"Berlin");

        WebElement degree=driver.findElement(RelativeLocator.with(By.tagName("h1")).above(city));
        String degreeText=degree.getText();
        System.out.println(degreeText);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();

    }
}
