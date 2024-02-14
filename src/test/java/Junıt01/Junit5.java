package Junıt01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit5 {
    static WebDriver driver;

    /*
Go to google homepage
Do the following tasks by creating 3 different test methods.
*- Tüm test() methodları çalışmadan önce "Testler çalışmaya başlıyor" yazdıralım
*- Tüm test() methodları çalıştıktan sonra "Testlerin çalışması bitti" yazdıralım
3- Test if the title is the same when the page window is maximize and minimize
4- Test if the title does not contain "Video" when the page window is fullscreen
5- Test if the URL contains "google".
*/
    @BeforeAll // BeforeAll sadece çalışır bir kez static olmak zorunda
    public static void beforeAllTest(){
        driver=new ChromeDriver();// her classtan önce bir driver obje oluşturulur

    }

    @BeforeEach// her testten önce bir kez çalışır
    public void beforeTest(){
        System.out.println("Test çalışıyor");
    }

    @Test
    public void testTitle(){
        driver.manage().window().maximize();
        String maxTitle=driver.getTitle();//windows un max olduğu durumda elde edilen title
        driver.manage().window().minimize();
        String minTitle=driver.getTitle();//windows un min olduğu durumda elde edilen title
    //  Assertions.assertEquals(maxTitle,minTitle);



    }

    @AfterEach// her testten sonra bir kez çalışır
    public void afterTest(){
        System.out.println("Test bitti");
    }

    @AfterAll
    public static void afterAllTest(){
        driver.quit();
        System.out.println("Test tamamen bitti");
    }

}
