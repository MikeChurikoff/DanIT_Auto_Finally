package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElements {

    static void clearAndSendKeys(WebDriver driver, String xpath, String text){
        WebElement element= driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(text);
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        /*driver.get("https://www.guinnessworldrecords.com/search");
        WebElement acceptCookiesButton = driver.findElement(By.id("ez-accept-all"));
        acceptCookiesButton.click();

        WebElement searchField = driver.findElements(By.tagName("input")).get(1);
        searchField.sendKeys("input");
        Thread.sleep(2000);
        searchField.clear();
        Thread.sleep(2000);
        searchField.sendKeys("Most handstand push ups");
        searchField.sendKeys(Keys.ENTER);*/

        /*driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//input[@name='search']"))
                .sendKeys("iPhone");
        clearAndSendKeys(driver,"//input[@name='search']","Samsung");
        WebElement input = driver.findElement(By.xpath("//input[@name='search']"));
        Thread.sleep(10000);
        input.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        input.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        input.sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        input.sendKeys(Keys.DOWN);
        input.sendKeys(Keys.ENTER);
*/

        /*driver.get("https://rozetka.com.ua/");
        WebElement input = driver.findElement(By.xpath("//input[@name='search']"));
        System.out.println(input.getText());
        System.out.println(input.getTagName());
        System.out.println(input.getClass());
        //placeholder
        System.out.println(input.getAttribute("placeholder"));
        System.out.println(input.getAttribute("class"));
        System.out.println(input.getCssValue("background-repeat"));
        input.sendKeys("Lenovo");
        input.submit();*/

        /*driver.get("https://www.guinnessworldrecords.com/search");
        WebElement acceptCookiesButton = driver.findElement(By.id("ez-accept-all"));
        acceptCookiesButton.click();

        WebElement searchField = driver.findElements(By.tagName("input")).get(1);
        searchField.sendKeys("Most handstand push ups");
        searchField.submit();*/

        driver.get("https://rozetka.com.ua/");
        WebElement input = driver.findElement(By.xpath("//button[contains(text(),'Найти')]"));
        System.out.println(input.getLocation());
        System.out.println("координата x "+ input.getLocation().x);
        System.out.println("координата y "+ input.getLocation().y);

        WebElement catalog = driver.findElement(By.xpath("//button[@aria-label='Каталог']"));
        System.out.println(catalog.getLocation());
        System.out.println("Размер данного элемента "+catalog.getSize());
        System.out.println("Высота данного элемента "+catalog.getSize().height);
        System.out.println("Ширина данного элемента "+catalog.getSize().width);

    }
}
