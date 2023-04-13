package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ActionFinal {
    public static String clickOnElementAndGetWindowHandler(WebDriver driver, By locator){
        Set<String> set1 = driver.getWindowHandles();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String secondDes = set2.iterator().next();
return secondDes;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        String firstDes = driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        String secondDes= clickOnElementAndGetWindowHandler(driver,By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/a"));

        /*Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/a"));
        actions.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String secondDes = set2.iterator().next();*/
        driver.switchTo().window(secondDes);
        driver.get("https://dan-it.com.ua/");
    }
}
