package lesson9.tests;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MoveToAndSearchTest {
    @Test
    public void moveToAndSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://foodex24.pl/ua");
        Waiters waiters = new Waiters(driver);
        waiters.waitForVisabilityOfElementReturn(By.xpath("//span[text()='Приховати']")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Риба та морепродукти']"))).perform();
        waiters.waitForVisabilityOfElementReturn(By.xpath("//div[text()='Паста з морепродуктів']")).click();

        waiters.waitForTitleContains("Замовити Паста з морепродуктів");
        waiters.waitForVisabilityOfElementReturn(By.xpath("//input[@type='search']")).sendKeys("Халва" + "\n");
        //waiters.waitForVisabilityOfElementReturn(By.xpath("//input[@type='search']")).sendKeys("\n");
        //button[@title='Пошук товарів']
        Thread.sleep(4000);
        waiters.waitForVisabilityOfElementReturn(By.xpath("//button[@title='Пошук товарів']")).click();
        waiters.waitForTitleContains("Пошук");
        assertEquals((driver.findElement(By.xpath("//h1/span[1]")).getText()), "«Халва»");
        driver.quit();
    }
}
