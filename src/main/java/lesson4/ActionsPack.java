package lesson4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ActionsPack {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://dan-it.com.ua/uk/");*/
        //driver.findElement(By.xpath("//a[text()='Українська']")).click();


        //Для работы с классом Actions и его методами необходимо создать экземпляр
        //данного класса.
        Actions actions = new Actions(driver);


        //moveByOffset() позволяет наводить курсор на элемент по координатам.
        //a[text()='Для дорослих']
       /* System.out.println(driver.findElement(By.xpath("//a[text()='Для дорослих']")).getLocation());
        System.out.println(driver.findElement(By.xpath("//a[text()='Для дорослих']")).getSize());
        int x = driver.findElement(By.xpath("//a[text()='Для дорослих']"))
                        .getLocation().x+
                (driver.findElement(By.xpath("//a[text()='Для дорослих']"))
                        .getSize().width)/2;
        int y = driver.findElement(By.xpath("//a[text()='Для дорослих']"))
                .getLocation().y+
                (driver.findElement(By.xpath("//a[text()='Для дорослих']"))
                        .getSize().height)/2;
        System.out.println(x);
        System.out.println(y);
        Thread.sleep(2000);
        actions.moveByOffset(x,y).build().perform();*/


        //moveToElement() позволяет наводить курсор на элемент.
        //a[text()='Java']
        /*actions.moveToElement(driver.findElement(By.xpath("//a[text()='Java']"))).
                click().build().perform();*/


        //moveToElement(element, int xOffset, int yOffset) позволяет наводить курсор на элемент
        //относительно координат его центра
        /*actions.moveToElement(driver.findElement(By.xpath("//a[text()='Java']")),0,80).
                click().build().perform();*/


        //click(), позволяет кликать по элементу, либо по месту где находится курсор


        //один из вариантов реализации drag n drop
        //driver.get("https://www.ibuongiorno.com/about");


        driver.get("https://www.signesduquotidien.org/");
        WebElement firstCircle = driver.findElement(By.id("menu-btn"));
        Thread.sleep(2000);
        firstCircle.click();
        Thread.sleep(2000);
        WebElement firstCircle2 = driver.findElement(By.id("menu-btn"));
        WebElement secondCircle = driver.findElement(By.xpath("//span[text()='Ouverture']/parent::div"));
        /*actions.moveToElement(secondCircle).clickAndHold().moveToElement(firstCircle2)
                .release().build().perform();*/
        actions.dragAndDrop(secondCircle,firstCircle2).perform();
        //.menu-icon.dots-icon
        //.menu-icon.icon-ouverture
        //.menu-icon.dots-icon


        //keyUp(), keyDown()

        //driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        //Frame
        //contextClick()

        //Alert
        //doubleClick()





    }
}


