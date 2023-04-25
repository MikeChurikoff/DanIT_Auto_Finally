package lesson9.tests;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DragNDropTest {
    @Test
    public void dragNdropSession() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/drag_drop.html");


        //li[@id='credit2']/a    //ol[@id='bank']
        //li[@id='credit1']/a    //ol[@id='loan']

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='gdpr-consent-notice']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='gdpr-consent-notice']")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"save\"]")));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"save\"]"));
        element.click();
        Actions actions = new Actions(driver);
        actions.dragAndDrop((driver.findElement(By.xpath("//li[@id='fourth'][1]/a"))),
                (driver.findElement(By.xpath("//ol[@id='amt8']")))).perform();
        actions.dragAndDrop((driver.findElement(By.xpath("//li[@id='fourth'][2]/a"))),
                (driver.findElement(By.xpath("//ol[@id='amt7']")))).perform();

        actions.dragAndDrop((driver.findElement(By.xpath("//li[@id='credit2']/a "))),
                (driver.findElement(By.xpath("//ol[@id='bank']")))).perform();
        actions.dragAndDrop((driver.findElement(By.xpath("//li[@id='credit1']/a"))),
                (driver.findElement(By.xpath("//ol[@id='loan']")))).perform();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Perfect!']")));
        WebElement perfect = driver.findElement(By.xpath("//a[text()='Perfect!']"));
        assertTrue(perfect.isDisplayed());
        assertEquals(perfect.getText(),"Perfect!");
        driver.quit();
    }
}
