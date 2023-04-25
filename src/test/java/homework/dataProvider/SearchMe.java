package homework.dataProvider;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchMe {
    @Test(dataProvider = "searchProvider")
    public void searchMe(String input){
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        //input[@placeholder='Я ищу ...']
        new Waiters(driver).waitForVisabilityOfElement(By.xpath("//input[@placeholder='Я ищу ...']"));
        driver.findElement(By.xpath("//input[@placeholder='Я ищу ...']")).sendKeys(input);
        driver.findElement(By.xpath("//input[@value='Найти']")).click();
        new Waiters(driver).waitForTitleContains("Найдено по запросу");
        if(driver.findElements(By.tagName("h1")).get(0).getText().contains("Результаты поиска")){
            String actual = driver.findElement(By.xpath("//div[@class='search-page__box-title']//label"))
                    .getText();
            String expected = "«"+input+"»";
            assertTrue(actual.equalsIgnoreCase(expected));
        }if(driver.findElements(By.tagName("h1")).get(0).getText().contains("Найдено по запросу")){
            String actual = driver.findElements(By.tagName("h1")).get(0).getText().replace("Найдено по запросу ","");
            String expexted = "«"+input+"»";
            assertTrue(actual.equalsIgnoreCase(expexted));
            driver.quit();
        }
    }
    @DataProvider(name = "searchProvider")
    public Object[] search(){
        return new Object[]{
                "input","смысл","машина"
        };
    }
}
