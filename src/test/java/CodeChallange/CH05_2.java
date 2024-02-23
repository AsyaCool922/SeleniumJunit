package CodeChallange;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CH05_2 {
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void test1() throws InterruptedException {
        int index=0;
        for (int i = 0; i < 3; i++) {

            Faker faker = new Faker();
            WebElement calc = driver.findElement(By.xpath("//*[@id=\"calculatetest\"]"));
            calc.click();

            WebElement nummer1 = driver.findElement(By.xpath("//*[@id=\"number1\"]"));
            nummer1.sendKeys(faker.number().digit());
            Thread.sleep(1000);

            WebElement nummer2 = driver.findElement(By.xpath("//*[@id=\"number2\"]"));
            nummer2.sendKeys(faker.number().digit());
            Thread.sleep(1000);

            WebElement funkt = driver.findElement(By.xpath("//*[@id=\"function\"]"));
            Select select = new Select(funkt);
            select.selectByIndex(index++);
            Thread.sleep(1000);

            WebElement button = driver.findElement(By.xpath("//*[@id=\"calculate\"]"));
            button.click();
            beforeAll();

        }
    }

}
