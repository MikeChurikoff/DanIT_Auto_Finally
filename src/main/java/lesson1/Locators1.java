package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

    private static class Url {
        private static final String applyToSet = "https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/";
        private static final String loginPage = "https://www.guinnessworldrecords.com/Account/Login";
    }

    private static class Locators {
        private static final By acceptCookies = By.id("ez-accept-all");
        private static final By linkText = By.xpath("//div[@class='buttons-holder block block-4-12']" +
                "/../child::div[2]/p/following-sibling::p/a");
        private static final By recordsShowcase = By.xpath("//div[@class='columned" +
                " block block-4-12'][last()]");
        private static final By hallOfFame = By.xpath("//div[@class='columned block block-4-12'][3]");
        private static final By mailForm = By.xpath("//input[@data-val-length-max<=255]" +
                "[@data-val-length-max!=100]");
        private static final By passForm = By.xpath("//input[@data-val-length-max=100]");

    }


    public static void main(String[] args) throws InterruptedException {

//driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
//driver.findElement(By.id("ez-accept-all")).click();
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//Поиск элемента по id

       /* driver.get("https://www.guinnessworldrecords.com/");
        driver.findElement(By.id("ez-accept-all")).click();*/
//Поиск элемента по name
        /*driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        driver.findElement(By.name("q")).sendKeys("Это атрибут нейм");*/
//Поиск элемента по Class Name
/*
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("green-background")).click();
*/

//Поиск элемента по Tag Name
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElements(By.tagName("input")).get(1).sendKeys("input");*/

//Поиск элемента по Link Text
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();*/


//Поиск элемента по Partial Text
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.partialLinkText("PROCESS")).click();*/


//Xpath //имя_тега[@атрибут='значение']
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//a[@id='search']")).click();*/


//xpath поиск по тексту
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//span[text()='en']")).click();
        Thread.sleep(2000);*/


//xpath поиск по части текста. Метод contains
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Standard')]")).click();*/


//xpath поиск по части атрибута. комбинирование
    /*    driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();*/
    /*    driver.findElement(By
                .xpath("//div[contains(@class, 'block block-4-12')][not(contains(@class, 'columned'))]")).click();
*/


//относительный путь внутри относительного пути
      /*  driver.findElement
                (By.xpath("//div[contains(@class, 'block block-4-12')]//a[text()='Apply now']")).click();
*/
//xpath передвижение по DOM дереву
// /.. - вверх по тегу
// /имя_тега вниз к указанному тегу
//  переход на родительский тег /parent::div
// переход на доченрний тег /child::a
// переход на параллельный тег /following-sibling::*[1]
// предок /ancestor::span
// /descendant::h3
    /*    driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='buttons-holder block block-4-12']" +
                "/../child::div[2]/p/following-sibling::p/a")).getText());
        driver.quit();
*/

//xpath ключевые слово last(), указание порядкового номера
   /*     driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//div[@class='columned block block-4-12'][last()]")).click();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.xpath("//div[@class='columned block block-4-12'][3]")).click();
*/
//xpath операторы >, <, >=, <=, !=
       /* driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//input[@data-val-length-max<=255]" +
                "[@data-val-length-max!=100]")).sendKeys("mailmail@gmail.com");
        driver.findElement(By.xpath("//input[@data-val-length-max=100]"))
                .sendKeys("password");*/


        //Использование вложенного класса Url
        driver.get(Url.applyToSet);
        driver.findElement(Locators.acceptCookies).click();
        System.out.println(driver.findElement(Locators.linkText).getText());

        driver.get(Url.applyToSet);
        driver.findElement(Locators.recordsShowcase).click();
        driver.get(Url.applyToSet);
        driver.findElement(Locators.hallOfFame).click();

        driver.get(Url.loginPage);
        driver.findElement(Locators.mailForm).sendKeys("mailmail@gmail.com");
        driver.findElement(Locators.passForm)
                .sendKeys("password");

    }
}













