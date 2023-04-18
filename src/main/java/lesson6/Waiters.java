package lesson6;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    private final  WebDriver driver;
    private static final long EXPLICITY_WAIT=20L;

    public Waiters(WebDriver driver){
        this.driver=driver;
    }



    private FluentWait<WebDriver> fluentWait(Long duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function,Long timeOutInSeconds){
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }
    public void waitForVisabilityOfElement(WebElement element){
        waitForFunction(ExpectedConditions.visibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitForVisabilityOfElement(By by){
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)),EXPLICITY_WAIT);
    }
    public WebElement waitForVisabilityOfElementReturn(WebElement element){
       return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForVisabilityOfElementReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //textToBePresentInElementValue
    public void waitFortextToBePresentInElementValue(WebElement element, String text){
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(element,text),EXPLICITY_WAIT);
    }
    public void waitForInvisibilityOf(WebElement element){
        waitForFunction(ExpectedConditions
                .invisibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitForTitleContains(String text){
        waitForFunction(ExpectedConditions
                .titleContains(text),EXPLICITY_WAIT);
    }
    public WebElement waitForPresenceOfElementLocated(By by){
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitSomeSecond(int seconds){
        int milisecond = seconds*1000;
        try {
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
