package lesson9;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HomeworkParams {
    @Test
    @Parameters({"input"})
    public void checkSearc(String text) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        Waiters waiters = new Waiters(driver);
        WebElement search = waiters.waitForVisabilityOfElementReturn(By.xpath("//input[@placeholder='Я ищу ...']"));
        search.sendKeys(text);
        WebElement button = waiters.waitForVisabilityOfElementReturn(By.xpath(" //input[@value='Найти']"));
        button.click();
        waiters.waitForTitleContains("Найдено по запросу");
        if((driver.findElement(By.tagName("h1")).getText()).contains("Результаты поиска")){
            waiters.waitForVisabilityOfElement(By.xpath("//div[@class='search-page__box-title']/label"));
            assertEquals((driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText()),"«"+text+"»",
                    "Actual result = "+ (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText())+
                            " Expected "+ text);
        }else {
            waiters.waitForVisabilityOfElement(By.tagName("h1"));
            String result = driver.findElement(By.tagName("h1")).getText().replace("Найдено по запросу ","");
            assertEquals(result,"«"+text+"»",
                    "Actual result = "+ (driver.findElement(By.tagName("h1")).getText())+
                            " Expected "+text);
        }
        driver.quit();
    }
}
