package CodeChallange;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CH07 {

    //Faker  Faker faker=new Faker();  : Fake bilgiler uretir.
    /*

1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
3) Fill form and submit
4) Verify get message after all fields are not full
  */
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

        Faker faker = new Faker();

      //  driver.findElement(By.name("first-name"))
              //  .sendKeys(faker.name().firstName());
        driver.findElement(By.name("last-name"))
                .sendKeys(faker.name().lastName());
        driver.findElement(By.name("address"))
                .sendKeys(faker.address().fullAddress());
        driver.findElement(By.name("zip-code"))
                .sendKeys(faker.address().zipCode());
        driver.findElement(By.name("city")).sendKeys(faker.address().city());
        driver.findElement(By.name("country"))
                .sendKeys(faker.address().country());
        driver.findElement(By.name("e-mail"))
                .sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("phone"))
                .sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.name("job-position"))
                .sendKeys(faker.job().position());
     //   driver.findElement(By.name("company")).sendKeys(faker.company().name());

        driver.findElement(By.tagName("form")).submit();



    }

//    @AfterAll
//    public static void tearDown() {
//        driver.quit();
//    }
}