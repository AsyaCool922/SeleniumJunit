package Junıt01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit4 {
    static WebDriver driver;

    //Testleri yapmamız için main bloğuna ihtiyacımız yok

    /*
Go to youtube homepage
Do the following tasks by creating 4 different test methods.
*- Her test() methodundan önce "Test çalışıyor" yazdıralım
*- Her test() methodundan sonra "Test bitti" yazdıralım
3- Test if the currentURL contains "youtube"
4- Test if the title does not contain "Video".
5- Test if the URL contains "youtube".
6- Test if the sourcePage contains "youtube".
*/
    @BeforeAll // BeforeAll sadece çalışır bir kez static olmak zorunda
    public static void beforeAllTest(){
        driver=new ChromeDriver();// her classtan önce bir driver obje oluşturulur
        driver.manage().window().maximize();
    }

    @BeforeEach// her testten önce bir kez çalışır
    public void beforeTest(){
        System.out.println("Test çalışıyor");
    }

    @AfterEach// her testten sonra bir kez çalışır
    public void afterTest(){
        System.out.println("Test bitti");
    }
    @Test
    public void test1Url(){
        driver.get("https://youtube.com");
        String expectedUrl="youtube";// Beklenen ,istenen,
        String actual=driver.getCurrentUrl();//Mevcutta olan
        System.out.println(driver.getCurrentUrl());
        if (actual.contains(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

       // Assertions.assertEquals(expectedUrl,actual);

    }

    @Test @Disabled("Test 1 beklemeye alındı")
    public void test2Title(){
        driver.get("https://youtube.com");
        String expectedTitle="video";// Beklenen ,istenen,
        String actualTitle=driver.getTitle();//Mevcutta olan
        System.out.println(driver.getCurrentUrl());
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        // Assertions.assertEquals(expectedUrl,actual);

    }


        @AfterAll
        public static void afterAllTest(){
            driver.quit();
            System.out.println("Test tamamen bitti");
        }


}
