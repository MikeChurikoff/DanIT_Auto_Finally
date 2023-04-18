package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex3 {
    private static class Locators {
        private static final By acceptCookies = By.id("ez-accept-all");

        private static final By userName = By.xpath("//input[@id='Username']");
        private static final By pass = By.xpath("//input[@id='Password']");
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Waiters waiters = new Waiters(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = waiters.waitForVisabilityOfElementReturn(Locators.acceptCookies);
        accept.click();
        WebElement userNameField = waiters.waitForVisabilityOfElementReturn(Locators.userName);
        waiters.waitFortextToBePresentInElementValue(userNameField, "Хомяк");
        driver.findElement(Locators.pass).sendKeys("Password");
        driver.get("https://uhomki.com.ua/");
        waiters.waitForInvisibilityOf(userNameField);
        wait.until(ExpectedConditions.titleIs("\"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")"));
        waiters.waitForTitleContains("\"У Хомки\"");
        WebElement element = waiters.waitForPresenceOfElementLocated(By.xpath("//span//a[@href='/ru/oplata-i-dostavka/']"));
        wait.until(ExpectedConditions.textToBePresentInElement(element, "Оплата и доставка"));
        System.out.println(driver.getTitle());
        waiters.waitSomeSecond(2);
        driver.quit();
    }
}

