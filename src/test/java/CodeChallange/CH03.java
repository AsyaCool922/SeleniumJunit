package CodeChallange;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CH03 {
//    driver.manage().window( );Method’lari
//-  driver.manage().window().maximize();    Browser’i  maximize yapar
//-  driver.manage().window().minimize();    Browser’i  minimize yapar
//-  driver.manage().window().fullscreen();   Browser’i full screen yapar
//-  driver.manage().window().getPosition( );   Browser’in koordinatlarini verir
//-  driver.manage().window().getSize( );     Browser’in olculerini verir
//-  driver.manage().window().setPosition(new Point ( x:80 , y:0 ) ) ; Browser’i  istenen koordinata tasir
//-  driver.manage().window().setSize(new Dimension( 800 , 600 )); Browser’i  istenen olculere getirir.


        /*
//  go to https://cirro.io/users/sign_in
//  enter mail with using Faker Library
//  enter password
//  click login button
    verify the Invalid Email or password.

     */

    static WebDriver driver;//class seviyesinde tanımlamalıyız
    static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void test1() {
        driver.get("https://cirro.io/users/sign_in");
        Faker faker=new Faker(new Locale("tr"));
        // Generate random Turkish first and last names
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        // Choose a Turkish domain name (replace with your preferred option)
        String domainName = "gmail.com.tr"; // Example Turkish domain

        // Create email address using Turkish formatting
        String emailAddress = String.format("%s.%s@%s", firstName.toLowerCase(), lastName.toLowerCase(), domainName);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(faker.phoneNumber().cellPhone());

    }





    @AfterAll
    public static void tearDown() {
       // driver.close();

    }
}
