package lesson9.tests;

import lesson6.Waiters;
import lesson9.Actionist;
import lesson9.Assertions;
import lesson9.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DragNDrop2 {
    @Test
    public void dragNdropSession() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        Waiters waiters = new Waiters(driver);
        Actionist actions = new Actionist(driver);
        Assertions asserts = new Assertions(driver);
        Elements elements = new Elements(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        elements.clickOnElementInsideFrameXpath("//*[@id=\"gdpr-consent-notice\"]", "//*[@id=\"save\"]");
        actions.dragNDrop("//li[@id='fourth'][1]/a", "//ol[@id='amt8']");
        actions.dragNDrop("//li[@id='fourth'][2]/a", "//ol[@id='amt7']");
        actions.dragNDrop("//li[@id='credit2']/a", "//ol[@id='bank']");
        actions.dragNDrop("//li[@id='credit1']/a", "//ol[@id='loan']");

        waiters.waitForVisabilityOfElement(By.xpath("//a[text()='Perfect!']"));
        asserts.elementIsDisplayed("//a[text()='Perfect!']");
        asserts.equalsOfText("//a[text()='Perfect!']", "Perfect!");
        driver.quit();
    }
}
