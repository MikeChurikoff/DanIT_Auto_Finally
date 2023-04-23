package testng.dataProvider;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Ex1 {
    @Test(dataProvider = "searchParameters")
    public void search(String inputMessage, String expretedValue){
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        driver.get("https://klopotenko.com/");
        WebElement search = (new Waiters(driver)).waitForPresenceOfElementLocated(By.id("open-search"));
        search.click();
        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Пошук...']"));
        input.sendKeys(inputMessage);
        input.submit();
        (new Waiters(driver)).waitForTitleContains("Ви шукали "+inputMessage);
        assertTrue(driver.findElement(By.tagName("h2")).getText()
                .replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "").equals(expretedValue));
        driver.quit();
    }
//    @Test(dataProvider = "searchParametersFalse")
//    public void login(String mail, int pass){
//        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://klopotenko.com/");
//        WebElement element = (new Waiters(driver)
//                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
//        element.click();
//        WebElement loginField = driver.findElement(By.xpath(""));
//        WebElement passField = driver.findElement(By.xpath(""));
//        loginField.sendKeys(mail);
//        String password = String.valueOf(pass);
//        passField.sendKeys(password);
//        passField.submit();
//        driver.quit();
//
//    }
    @DataProvider(name = "searchParameters")
    public Object[][] createData(){
        return new Object[][]{
                {"Meat","MEAT"},
                {"Carrot","CARROT"},
                {"Potato","POTATO"}
        };
    }
    @DataProvider(name = "searchParametersFalse")
    public Object[][] createData2(){
        return new Object[][]{
                {"roman@wer.com",345278},
                {"romadsdsne@wer.com",22221221},
                {"romaddsane@wer.com",332323}
        };
    }
}
