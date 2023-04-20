package lesson5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionEx2 {
    public static void dranNdrop(Actions actions, WebDriver driver,int x,int y ){
        WebElement centr = driver.findElement(By.xpath("//h2[text()='I Buongiorno']"));
        actions.moveByOffset(x,y).clickAndHold().pause(5)
                .moveToElement(centr,-50,0).release().build().perform();

    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[text()='Contatti']")));

        int startX = driver.findElement(By.xpath("//a[text()='Contatti']"))
                .getLocation().x;
        System.out.println(startX);
        int startY = driver.findElement(By.xpath("//h2[text()='I Buongiorno']"))
                .getLocation().y;
        System.out.println(startY);
        int finishX = driver.findElement(By.xpath("//h2[text()='I Buongiorno']"))
                .getLocation().x-100;
        System.out.println(finishX);
        Actions actions = new Actions(driver);
        dranNdrop(actions,driver,startX,startY);
        /*WebElement centr = driver.findElement(By.xpath("//h2[text()='I Buongiorno']"));
        actions.moveByOffset(startX,startY).clickAndHold().pause(5)
                .moveToElement(centr,-50,0).release().build().perform();*/
    }
}
