package lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitersFor {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //неявные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //неявные ожидания загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
      /*  driver.get("https://dan-it.com.ua/uk/");
        Thread.sleep(2000);*/
        //обновление страницы
        /*driver.navigate().refresh();
        Thread.sleep(2000);*/
        //неявные ожидания отработки скриптов страницы
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));



        //ЯВНЫЕ ОЖИДАНИЯ

        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        /*driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept-choices\"]")));
        driver.findElement(By.xpath("//*[@id=\"accept-choices\"]")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']")));

        *//*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
        WebElement tryIt = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryIt.click();*//*
        WebElement tryIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
        tryIt.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();*/

       /* driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookies = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accept-choices']")));
        acceptCookies.click();
        wait.until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']")));
        WebElement tryIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
        tryIt.click();
        //driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();*/

        //elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
    /*    driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        driver.findElement(By.id("ez-accept-all")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='RememberMe']")));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='RememberMe']")));
        driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("Хомяк");
        wait.until(ExpectedConditions.elementSelectionStateToBe(driver.
                findElement(By.xpath("//input[@id='RememberMe']")), false));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Хомяк");*/


        //presenceOfElementLocated(), textToBePresentInElementValue(), invisibilityOf(),
        //titleContains(), titleIs()
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ez-accept-all")));
        driver.findElement(By.id("ez-accept-all")).click();
        //wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='Username']"),"Хомяк"));
        driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Хомяк");
        WebElement userName = driver.findElement(By.xpath("//input[@id='Username']"));
        driver.get("https://dan-it.com.ua/uk");
        wait.until(ExpectedConditions.invisibilityOf(userName));
        wait.until(ExpectedConditions.titleContains("програмування в Києві"));
        wait.until(ExpectedConditions.titleIs("Курси програмування в Києві ☑️ IT курси з працевлаштуванням"));
        //wait.until(ExpectedConditions.titleContains("DAN.IT"));
        System.out.println(driver.getTitle());*/

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Username']")));
        wait.until(ExpectedConditions.textToBePresentInElementValue(userNameField,"Хомяк"));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");
        driver.get("https://uhomki.com.ua/");
        wait.until(ExpectedConditions.invisibilityOf(userNameField));

        wait.until(ExpectedConditions.titleIs("\"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")"));
        wait.until(ExpectedConditions.titleContains("\"У Хомки\""));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//a[@href='/ru/oplata-i-dostavka/']")));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Оплата и доставка"));
        System.out.println(driver.getTitle());*/

        //СВОБОДНЫЕ ОЖИДАНИЯ
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);

        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        driver.findElement(By.id("ez-accept-all")).click();












    }
}
