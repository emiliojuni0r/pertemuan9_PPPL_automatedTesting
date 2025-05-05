import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class t_latihanPer10nomor1 {

    @Test
    public void testloginFailed() {
        WebDriver driver;

        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("login_button").submit();

        By login_button = By.id("login-button");
        driver.findElement(login_button).submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By error_message = By.xpath("//*[contains(text(), 'Epic sadface: Username is required')] ");
        WebElement error_msg = driver.findElement(error_message);

        System.out.println(error_msg.getText());

    }

}
