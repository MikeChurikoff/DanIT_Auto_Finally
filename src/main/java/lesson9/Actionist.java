package lesson9;

import lesson6.Waiters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionist {
    private  final Elements elements;
    private  final Actions actions;
    private  final WebDriver driver;

    public Actionist(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        elements = new Elements(driver);
    }

    public void dragNDrop(String xpath1, String xpath2){
        actions.dragAndDrop(elements.findElementByXpath(xpath1),elements.findElementByXpath(xpath2)).perform();
    }


}
