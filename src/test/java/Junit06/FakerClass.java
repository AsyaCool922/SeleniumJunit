package Junit06;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class FakerClass {
    //Java FakerClass class Java'nın bir kütüphanesi
    //Gerçek görünümlü sahte veriler oluşturmamızı sağlar https://github.com/DiUS/java-faker (Adresi)
    //Java FakerClass i kütüphaneden eklemek gerekir
    @Test
    public void FakerTest(){
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String lastNAme=faker.name().lastName();
        String city=faker.address().fullAddress();
        System.out.println(name+" "+lastNAme+"\n"+city);
        System.out.println("faker.number().numberBetween(3,7) = " + faker.number().numberBetween(3, 7));
        String book=Faker.instance().book().genre();// instance ile obj eoluşturulmadan faker class oluşturulabilir
        System.out.println(book);


    }

}
