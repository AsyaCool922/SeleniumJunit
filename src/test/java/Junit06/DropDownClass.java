package Junit06;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownClass {
    //Dropdown : acilir pencere
    //Dropdownlar ozel etkilesimler gerektirdiginden dolayi Selenium bize dropdownlar icin ayri bir class olusturmustur..
    //Class-> Select

    /*Dropdownlar ile calisirken
        * <select> elementi locate edilir  : //select[@id='oldSelectMenu']
        *  select elementi kullanilarak select objesi olusturulur
            Select select = new Select(webElement)
        *  select objesi araciligiyla metodlar kullanilir..
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
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://formstone.it/components/dropdown/demo/");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }//Close driver.

    @Test
    public void test() throws InterruptedException {

        //Locate dopdown
        WebElement dropDown1 = driver.findElement(By.id("demo_label"));
        Select select1 = new Select(dropDown1);
        //Create Select Object
        Select select = new Select(dropDown1);
        //Select by indeks
        select.selectByIndex(2);
        //getOptions() Web element listesi dönderir
        List<WebElement> options = select.getOptions();

        //.getText() bize visible değerleri verir
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        select.selectByIndex(5);
        Thread.sleep(2000);

        //select By visible text
        select.selectByVisibleText("Florida");
        Thread.sleep(2000);
        //selecet by Value

        select.selectByValue("WA");
//        WebElement one=driver.findElement(By.xpath("//option[@value='1']"));
//        one.click();
        Thread.sleep(3000);
        Assertions.assertTrue(select.isMultiple());
    }
        // Print all dropdown
        @Test
        public void testMutipleDrop() throws InterruptedException {
            WebElement multiDrop=driver.findElement(By.id("demo_multiple"));
            Select select2=new Select(multiDrop);
            List<WebElement>list=select2.getOptions();//

            for (WebElement webElement : list) {
                System.out.println("webElement.getText() = " + webElement.getText());
            }

            System.out.println("list.size() = " + list.size());
          // select2.selectByVisibleText("Three");

            select2.selectByIndex(5);
            select2.deselectAll();//Tüm seçimleri kaldırır
            Assertions.assertTrue(select2.isMultiple());
          //  Thread.sleep(4000);
//            for (int i = 0; i < list.size() ; i++) {
//
//                if (i==2){
//                    continue;
//                }
//                select2.selectByIndex(i);
//
//            }
            select2.selectByVisibleText(" One");
            Thread.sleep(2000);
            select2.selectByVisibleText(" Two");
            Thread.sleep(2000);
            select2.selectByVisibleText(" Five");

        }
    }

