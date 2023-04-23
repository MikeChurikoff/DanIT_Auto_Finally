package testng.groups;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Ex3 extends BaseTest{
    private static class Locators {
        private final static By meat = By.xpath("//li[@id='menu-item-5047912']//a[text()='М’ясні']");
        private final static By fish = By.xpath("//li[@id='menu-item-5047912']//a[text()='Рибне']");
        private final static By veg = By.xpath("//li[@id='menu-item-5047912']//a[text()='Овочеві']");
        private final static By garn = By.xpath("//li[@id='menu-item-5047912']//a[text()='Гарніри']");
        private final static By pasts = By.xpath("//li[@id='menu-item-5047912']//a[text()='Паста']");
        private final static By pizza = By.xpath("//li[@id='menu-item-5047912']//a[text()='Піца']");
    }

    private static class Labels {
        private final static String uaLocalisation = "UA";
        private final static String enLocalisation = "EN";
        private final static String meat = "М’ясні";
        private final static String fish = "Рибне";
        private final static String veg = "Овочеві";
        private final static String gar = "Гарніри";
        private final static String pasts = "Паста";
        private final static String pizza = "Піца";

    }

    @Test
    public void checkWebPageTitle() {
        driver.get("https://klopotenko.com/");
        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
        assertFalse(driver.getTitle().equals("Євген Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
        assertEquals(driver.getTitle(), "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(), "Євген Клопот4енко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
    }


    @Test
    public void checkofCheckBox() {
        driver.get("https://klopotenko.com/login/");
        WebElement checkbox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        assertFalse(newCheckBox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
    }


    @Test
    public void countOfIngredients() {
        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size() == 5, "Количество ингридиентов не равно 5, оно равно "
                + elements.size());
    }

    @Test
    public void checkLocalisation() {
        driver.get("https://klopotenko.com/login/");
        WebElement ua = driver.findElement(By.xpath("//span[text()='UA']"));
        WebElement en = driver.findElement(By.xpath("//span[text()='EN']"));
        assertTrue(ua.isDisplayed(), "Элемент не отображается");
        assertTrue(en.isDisplayed(), "Элемент не отображается");
        assertEquals(ua.getText(), Labels.uaLocalisation, "Not equals");
        assertEquals(en.getText(), Labels.enLocalisation, "Not equals");
    }

    @Test
    public void searchFunctionality() {
        WebElement search = (new Waiters(driver)).waitForPresenceOfElementLocated(By.id("open-search"));
        search.click();
        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Пошук...']"));
        String inputText = "Meat";
        input.sendKeys(inputText);
        input.submit();
        (new Waiters(driver)).waitForTitleContains("Ви шукали Meat");
        assertTrue(driver.findElement(By.tagName("h2")).getText()
                .replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "").equalsIgnoreCase(inputText));
    }
}
