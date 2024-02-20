package Junit02;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

//    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
//        Create webdriver object
//        1-Test userName input text.Send name
//        2-Test password input text.Send password


    WebDriver driver;

    @BeforeEach
    public  void setUp(){
        driver=new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
    }

    @Test
    public void test01userName(){
        WebElement userInput= driver.findElement(By.name("username"));
        userInput.sendKeys("asyacoll");

    }

    @Test
    public void test02Password(){
        WebElement passwword= driver.findElement(By.name("password"));
        passwword.sendKeys("asyacoll");

    }
    @Test
    public void test03TextArea(){
        WebElement comment= driver.findElement(By.name("comments"));
        comment.clear();
        comment.sendKeys("asyacoll");

    }





}
