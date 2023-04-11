package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Selectors {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");


        //Для работы с дропдаунами необходимо создать объект класса Select
        //для получения возможности работаь с его методами
        /*WebElement tranportSelect = driver.findElement(By.id("transport_type"));
        Select transport = new Select(tranportSelect);*/


        //selectByVisibleText(); выбор элемента с определенным тесктом
        /*transport.selectByVisibleText("Автобус");
        Thread.sleep(2000);*/


        //selectByValue() выбирает все элементы с заданным значением value
        /*WebElement regionSelect = driver.findElement(By.id("region_list"));
        regionSelect.click();
        Select region = new Select(regionSelect);
        region.selectByValue("5200");
        region.selectByVisibleText("Аланья");
*/


        //selectByIndex() выбор элемента по индексу. Индексирование начинается с нуля;
        Select adult = new Select(driver.findElement(By.id("adult")));
        adult.selectByIndex(3);


        //deselectByVisibleText(), deselectByValue(), deselectByIndex(), deselectAll
        //отменяют выбор элемента в зависимости от параметра
        Select hotelList = new Select(driver.findElement(By.id("hotel_list")));
        /*hotelList.selectByVisibleText("A Suite Side");
        hotelList.selectByIndex(5);
        hotelList.selectByValue("14006");
        Thread.sleep(2000);
        hotelList.deselectByIndex(5);
        Thread.sleep(2000);
        hotelList.selectByValue("14006");
        Thread.sleep(2000);
        hotelList.deselectByVisibleText("A Suite Side");
        Thread.sleep(2000);
        hotelList.selectByVisibleText("A Suite Side");
        hotelList.selectByIndex(5);
        hotelList.selectByValue("14006");
        Thread.sleep(2000);
        hotelList.deselectAll();*/



        //isMultiple(); возвращает true если данный select поддерживает множественный выбор
        System.out.println(adult.isMultiple());
        System.out.println(hotelList.isMultiple());


        //getOptions возвращает все элементы данного Select

       /* List<WebElement> elements =  hotelList.getOptions();
        for (WebElement element:elements){
            System.out.println(element.getText());
        }*/


        //getAllSelectedOptions() возвращает все выбранные option из select
        hotelList.selectByVisibleText("A Suite Side");
        hotelList.selectByIndex(5);
        hotelList.selectByValue("14006");
        List<WebElement> elements =  hotelList.getAllSelectedOptions();
        for (WebElement element:elements) {
            System.out.println(element.getText());
        }
        System.out.println("+++++++++++++++++++++++++++++");

        //getFirsSelectedOptions() возвращает первый выбранный элемент
            System.out.println(hotelList.getFirstSelectedOption().getText());
            driver.quit();


        //equals сравнивание двух элементов

    }
}
