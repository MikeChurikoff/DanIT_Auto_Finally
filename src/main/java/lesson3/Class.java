package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class {
    public static void main(String[] args) throws InterruptedException {
        //a[@class='page-header__phone']
        //a[text()='Українська']
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://dan-it.com.ua/");
        driver.findElement(By.xpath("//a[text()='Українська']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='page-header__phone']")).click();*/

        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("//span[text()='Вход']")).click();
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandles());
        driver.findElement(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[3]/span[1]/input")).click();
        ////

    }
}
