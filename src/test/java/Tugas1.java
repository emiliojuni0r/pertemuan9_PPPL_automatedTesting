import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Tugas1 {
    static private WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    void testHover (){
        Actions action = new Actions(driver);
        WebElement linkHover = driver.findElement(By.xpath("//a[contains(.,'Hovers')]"));
        linkHover.click();

        WebElement image1 = driver.findElement(By.className("figure"));
        action.moveToElement(image1).perform();

        WebElement findTitleUserHoverImage = driver.findElement(By.tagName("h5"));
        String textUsername = findTitleUserHoverImage.getText();
        Assertions.assertEquals("name: user1", textUsername);
    }

    @Test
    void TestdragAndDrop(){
        Actions action = new Actions(driver);
        WebElement linkHover = driver.findElement(By.xpath("//a[contains(.,'Drag and Drop')]"));
        linkHover.click();

        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));

        action.clickAndHold(boxA).moveToElement(boxB).release().perform();

        // check if first box contain 'B' (karena setelah drag and drop, B ditukar posisi dengan A namun id masih sama)
        WebElement checkBox = driver.findElement(By.id("column-a"));
        Assertions.assertEquals("B", checkBox.getText());
    }

    @Test
    void TestKeyPresses() {
        Actions action = new Actions(driver);
        WebElement linkHover = driver.findElement(By.xpath("//a[contains(.,'Key Presses')]"));
        linkHover.click();

        WebElement targetInput = driver.findElement(By.id("target"));
        targetInput.click();
        targetInput.sendKeys(Keys.SHIFT);

        // check apakah tertekan shift dengan assert dengan text yang nampil seusuai key yang dipress.
        WebElement textKeyPressed = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: SHIFT", textKeyPressed.getText());
    }

    @AfterEach
    void clean(){
        driver.navigate().back();
    }

    @AfterAll
    static void cleanAll(){
        driver.quit();
        driver = null;
    }
}
