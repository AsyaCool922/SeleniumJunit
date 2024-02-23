package Junit07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C28_Iframe {
    //Go to URL: https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz.
    //Delete the text in the text box
    //Type “Hi everyone”
    //Verify the text Elemental Selenium text is displayed on the page.

}
