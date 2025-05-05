import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BingTest {
//    @Test
//    public void testBing(){
//        WebDriver driver = new EdgeDriver();
//        driver.get("https://bing.com/");
//        System.out.println(driver.getTitle());
//        WebElement searchBar = driver.findElement(By.id("sb_form_q"));
//        searchBar.sendKeys("wisnu aji");
//
//        WebElement searchform = driver.findElement(By.id("sb_form"));
//        searchform.submit();
//    }

    private static WebDriver driver;

    // navigasi menu
    @BeforeAll
    static public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu/");
    }



}
