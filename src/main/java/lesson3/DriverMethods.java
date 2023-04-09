package lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        /*System.out.println(driver.manage().getCookies());

        Set<Cookie> set = driver.manage().getCookies();
        for (Cookie cookie:set){
            System.out.println(cookie);
        }
        System.out.println("Количество куков равно "+ set.toArray().length);

        System.out.println("Отдельная кука "+ set.toArray()[6]);*/

        //getCurrentUrl()
       /* driver.get("https://rozetka.com.ua/");
        System.out.println(driver.getCurrentUrl());*/
        /*driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getCurrentUrl());*/

//getTitle()
  /*      driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getTitle());
        driver.quit();*/
//getPageSource()
      /*  driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getPageSource());
        driver.quit();*/
//navigate
    /*    driver.get("https://dan-it.com.ua/program/kiev/java/");
        driver.findElement(By.xpath("//a[text()='О нас']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().to("https://rozetka.com.ua/");
        System.out.println(driver.getTitle());*/

//Работа с окнами

       /* driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getWindowHandle());
        String descr1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descr2= set2.iterator().next();
        driver.switchTo().window(descr2);
        driver.navigate().to("https://rozetka.com.ua/");
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(descr1);
        driver.close();
        Thread.sleep(2000);
        driver.quit();*/

        //driver.findElements();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElements(By.cssSelector(".columned.block.block-4-12>a"));
        ArrayList<WebElement> listOfElem = new ArrayList<>(driver.findElements(By.cssSelector(".columned.block.block-4-12>a")));
        for(WebElement webElement:listOfElem){
            System.out.println(webElement.getText());
        }
        driver.quit();

    }
}
