package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoo.kiev.ua/");
        WebElement buyTickets = driver.findElement(By.xpath("//b[text()='КУПИТИ КВИТОК']/.."));
        System.out.println(buyTickets.getText());
        System.out.println(buyTickets.getCssValue("color"));
        System.out.println(buyTickets.getCssValue("background-color"));
        driver.quit();
    }
}
