import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("green-background")).click();



    }
}
