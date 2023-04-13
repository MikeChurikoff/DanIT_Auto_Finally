package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionsEx {
    public static void getText(Select select){
        List<WebElement> elements = select.getAllSelectedOptions();
        for(WebElement element:elements){
            System.out.println(element.getText());
        }

    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        driver.findElement(By.xpath("//div[@class='hike_tour no_active']")).click();
        WebElement countryList= driver.findElement(By.id("country_list"));
        WebElement transportList= driver.findElement(By.id("transport_list"));
        WebElement cityList= driver.findElement(By.id("city_list"));

        Select country=new Select(countryList);
        Select transport = new Select (transportList);
        Select city = new Select (cityList);

        country.selectByVisibleText("Германия");
        country.selectByVisibleText("Греция");
        country.selectByVisibleText("Испания");
        country.deselectByVisibleText("Австрия");
        getText(country);
        Thread.sleep(3000);

        transport.selectByVisibleText("Автобус");
        transport.deselectByIndex(0);
        getText(transport);
        Thread.sleep(3000);

        city.selectByVisibleText("Киев");
        city.deselectByIndex(0);
        getText(city);

        driver.quit();
    }
}
