package lesson5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionDoubleAndContextClick {
    public static void main(String[] args) throws InterruptedException {
        //https://demo.guru99.com/test/simple_context_menu.html
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        //iframe[@id="gdpr-consent-notice"]
        //iframe[@aria-label='Окно диспетчера конфиденциальности']
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@aria-label='Окно диспетчера конфиденциальности']")));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Принять всё']")).click();

        //span[text()='right click me']
        //button[text()='Double-Click Me To See Alert']
        //span[text()='Quit']
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement
                (By.xpath("//span[text()='right click me']"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Quit']")).click();

        Thread.sleep(2000);
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();

        actions.doubleClick
                (driver.findElement(By.xpath
                        ("//button[text()='Double-Click Me To See Alert']"))).build().perform();

        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.accept();

        driver.quit();
    }
}
