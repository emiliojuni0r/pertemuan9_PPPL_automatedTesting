import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class tugasPertemuan10nomor2 {
    @Test
    void testcase1(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement row2 = driver.findElement(By.id("row2"));

        Assertions.assertTrue(row2.isDisplayed());

    }

    @Test
    void testcase2(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement row2 = driver.findElement(By.id("row2"));

        Assertions.assertTrue(row2.isDisplayed());

        WebElement inputRow2 = row2.findElement(By.tagName("input"));
        inputRow2.sendKeys("we wok de tok, not onli tok de tok");

        WebElement saveBtn = row2.findElement(By.name("Save"));
//        WebElement saveBtn = row2.findElement(By.id("save_btn"));
        saveBtn.click();

        WebElement confirmText = driver.findElement(By.id("confirmation"));
        Assertions.assertTrue(confirmText.isDisplayed());
    }

    @Test
    void testcase3(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement inputrow1 = driver.findElement(By.id("row1")).findElement(By.tagName("input"));

        WebElement btnEdit = driver.findElement(By.id("row1")).findElement(By.id("edit_btn"));
        btnEdit.click();

        inputrow1.clear();

        inputrow1.sendKeys("hydup jocqoawy");

        WebElement btnSave = driver.findElement(By.id("row1")).findElement(By.id("save_btn"));
        btnSave.click();

        Assertions.assertEquals("hydup jocqoawy", inputrow1.getAttribute("value"));
    }

    @Test
    void testcase4(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement textInstruction = driver.findElement(By.id("instructions"));

         WebElement addBtn = driver.findElement(By.id("row1")).findElement(By.id("add_btn"));
         addBtn.click();

        Assertions.assertTrue(textInstruction.isDisplayed());
    }


    @Test
    void testcase4_1() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        // Step 1: Find the instruction element
        WebElement instruction = driver.findElement(By.id("instruction"));

        // Step 2: Click the Add button
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();

        // Step 3: Wait a short time for the DOM to update
        try {
            Thread.sleep(1000); // or use WebDriverWait if preferred
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 4: Attempt to use the previously found instruction element
        boolean visible = instruction.isDisplayed();
        Assertions.assertTrue(visible);


        driver.quit();
    }

    @Test
    void testcase5() {
        WebDriver driver = new EdgeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add_btn")));
        addButton.click();

        WebElement row2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));
        Assertions.assertTrue(row2.isDisplayed());

        driver.quit();
    }
}
