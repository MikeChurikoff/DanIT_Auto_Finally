package lesson9;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
    }

    public WebElement findElement(By by) {
        try {
            waiters.waitForVisabilityOfElement(by);
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            waiters.waitForVisabilityOfElement(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getElementText(WebElement element){
        waiters.waitForVisabilityOfElement(element);
        return element.getText();
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }
    public void clickOnElement(WebElement element){
        waiters.waitForVisabilityOfElement(element);
        element.click();
    }
    public void clickOnElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }
    public void clickOnElementInsideFrameXpath(String xpathFrame, String xpathElemnt){
        waiters.waitForFrameAndSwitchXpath(xpathFrame);
        WebElement element =findElementByXpath(xpathElemnt);
        element.click();
    }
    public boolean isElementDisplayed(String xpath){
        return findElementByXpath(xpath).isDisplayed();
    }
}
