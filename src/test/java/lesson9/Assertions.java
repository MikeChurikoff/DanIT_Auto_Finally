package lesson9;

import lesson6.Waiters;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    private final WebDriver driver;
    private final Waiters waiters;
    private final Actionist actionist;
    private final Elements elements;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        waiters = new Waiters(driver);
        actionist = new Actionist(driver);
    }
    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath),"Элемент не отображается, а должен был");
    }
    public void equalsOfText(String xpath,String expectectText){
        assertEquals(elements.getElementText(elements.findElementByXpath(xpath)),expectectText,
                "Я ожидал получить текст "+expectectText+". А получил "+
                        elements.getElementText(elements.findElementByXpath(xpath))+".");
    }
}
