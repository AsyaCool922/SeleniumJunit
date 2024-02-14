package Junıt01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit3 {
    static WebDriver driver;

    @BeforeAll
    public static void beforeClass(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Before Class");
    }
    @BeforeEach
    public void before() {
        System.out.println("Before");
    }

    @AfterEach
    public void after() {
        System.out.println("After");
    }
    @Test @RepeatedTest(3)
    public void test01() {
        System.out.println("Tst01");
    }
    @AfterAll
    public static void afterClass(){
       driver.quit();
        System.out.println("After close");
    }





}
