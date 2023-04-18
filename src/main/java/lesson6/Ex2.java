package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://uhomki.com.ua/ru/");
        WebElement input = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@placeholder='поиск товаров']")));
        System.out.println(input.getAttribute("id"));
        driver.navigate().refresh();
        WebElement input2 = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@placeholder='поиск товаров']")));
        System.out.println(input2.getAttribute("id"));
        driver.quit();

    }

}
