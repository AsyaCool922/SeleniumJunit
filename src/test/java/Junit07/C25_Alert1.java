package Junit07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C25_Alert1 {
    /*
Alerts : Web sitelerinde iki tur alert vardir.
    1.HTML alerts : sag click yapip incelenebilir, dolayisla diger web elementler gibidir
    2.JS alerts: bunlar sag click yapilip incelenemez, dolayisiyla da diger WebElementler’den farklidir.
     Interview sorusu
        - Alertleri nasıl kullanırsın (handle edersin)
          driver.switchTo().alert()   bununla kullanılır.
          komutları:
          accept -> OK, TAMAM yani olumlu butona basmak
          dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
          getText -> Alertin mesaj alınır.
          SendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
 */
    /*
    Go to URL: http://demo.guru99.com/test/delete_customer.php
    Delete customer ID: 123
    Remove 2 alerts that appear.
     */

}
