package Junıt01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Junit2 {
    @Test
    public void test01() {
        System.out.println("Tst01");
    }

    @Test @Disabled("Disable this second test")
    public void test02() {
        System.out.println("Tst02");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before");
    }

    @AfterEach
    public void after() {
        System.out.println("After");
    }
}
