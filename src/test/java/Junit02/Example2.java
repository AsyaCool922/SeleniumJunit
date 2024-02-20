package Junit02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example2 {
   static WebDriver driver;
//    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
//       Create webdriver object
//        1-Create BeforeAll, BeforeEach,AfterAll ,Test anotains
//        2-Test page title equal "Form"
//        3-Test url contain "Form"
//        4-Test page after refresh page driver notNull

    @BeforeAll // BeforeAll sadece çalışır bir kez static olmak zorunda
    public static void beforeAllTest(){
        driver=new ChromeDriver();// her classtan önce bir driver obje oluşturulur
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeEach// her testten önce bir kez çalışır
    public void beforeTest(){
      driver.manage().window().maximize();
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
