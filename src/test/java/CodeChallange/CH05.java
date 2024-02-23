package CodeChallange;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
 /*  select objesi araciligiyla metodlar kullanilir..
         1-selectByIndex() : option elementinin indexi
         2-selectByValue() : option elementinin value attribute u
         3-selectByVisibleText(): option elementinin gorunur yazisi
         //Select elementlerinde info amaciyla kullanilan methodlar
         select.getAllSelectedOptions(); -> multi selectte secili tum degerleri bize return eden methoddur.
         select.getFirstSelectedOption(); -> Secili ilk option elementini bize getirir.
         select.getOptions(); -> select elementinin tum optionlarini liste halinde return eder
         select.isMultiple(); -> select elementinin multiple secime uygun olup olmadigni bize boolean olarak return eder.

         // 1- deselectByIndex() -> option elementini index ile  kaldirir
         // 2- deselectByValue() -> option elemenini value attribute ile kaldirir
         // 3- deselectByVisibleText() -> option elementini gorunur yazisi (contenti) ile kaldirir
         // 4- deselectAll() -> Butun secimleri kaldirir.
         */
 // Navigate to  https://testpages.herokuapp.com/styled/index.html
 // Click on  Calculate under Micro Apps
 // Type any number in the first input
 // Type any number in the second input
 // Click on Calculate
 // Get the result
 // Print the result
 //Use Select class :
 //1-return all options for operators
 //2-select minus ,
//
//
public class CH05 {

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/calculator");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test1(){
        WebElement first=driver.findElement(By.cssSelector("input[id='number1']"));
        first.sendKeys("5");
        WebElement operator=driver.findElement(By.xpath("//select[@id='function']"));
        Select select=new Select(operator);
        List<WebElement> options = select.getOptions();

        //.getText() bize visible değerleri verir
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        select.selectByVisibleText("minus");

        WebElement second=driver.findElement(By.cssSelector("input[id='number2']"));
        second.sendKeys(String.valueOf(Faker.instance().number().numberBetween(1,10)));

        WebElement sumbitButton=driver.findElement(By.cssSelector("input[id='calculate']"));
        sumbitButton.submit();




    }


}
