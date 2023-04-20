package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void getAttribute(WebElement element)throws NoSuchAttributeEx{
        System.out.println("Название тега"+ element.getTagName());
        if(element.getAttribute("alert")==null){
            throw new NoSuchAttributeEx("Aтриубута alert не присутствует");
        }else {
            System.out.println("Название Aтриубута alert"+ element.getAttribute("alert"));
        }
        if(element.getAttribute("name")==null){
            throw new NoSuchAttributeEx("Aтриубута name не присутствует");
        }else {
            System.out.println("Название Aтриубута name"+ element.getAttribute("alert"));
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Username']")));
        try {
            getAttribute(userNameField);
        } catch (NoSuchAttributeEx e){
            System.out.println(e.getMessage());
        }

    }
}
