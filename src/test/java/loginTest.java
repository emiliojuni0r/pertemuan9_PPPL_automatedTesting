import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;

public class loginTest {

    @Test
    public void testLogin(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement inputUser = driver.findElement(By.id("user-name"));
        inputUser.sendKeys("standard_user");

        WebElement inputPass = driver.findElement(By.id("password"));
        inputPass.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.submit();

        WebElement teks = driver.findElement(By.className("title"));
        Assertions.assertEquals("Products", teks.getText()); //check apakah login dengan validasi salah satu teks yang muncul setelah login
        driver.quit();
    }
}
