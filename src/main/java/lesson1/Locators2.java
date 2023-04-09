package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {
    public static void main(String[] args) {
        //Поиск элементов при помощи css
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //пробелы заменяем точками
        //поиск по тегу
    /*    driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();
        System.out.println(driver.findElements(By.cssSelector("input")).toArray().length);
        driver.quit();*/

        //поиск по id. Используем символ #
        //
       /* driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.cssSelector("#search")).click();
*/

        //поиск по классу .имя_класса
//
//
      /*  driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.cssSelector("button.blue.btn-primary")).click();*/
        //Любой другой атрибут пишем в []
        //[title='Search']


        //нахождение по буквосочетанию
        //[title*='arc']


        //нахождение по первым символам
//[title^='Sear']

        //нахождение по последним символам
//[title$='arch']
      /*  driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.cssSelector("[title$='arch']")).click();*/
        //несколько классов плюс через пробел можем двигаться к дочерним вложенностям
//form.record-search.search-form-container>div>input
        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.cssSelector
                        ("form.record-search.search-form-container>div>input"))
                .sendKeys("first way");
        //еще один пример вложенности
// form.record-search.search-form-container [placeholder='Search']
        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.cssSelector
                ("form.record-search.search-form-container [placeholder='Search']"))
                .sendKeys("second way");
        //для поиска непосредственного ребенка можно использовать >

    }
}
