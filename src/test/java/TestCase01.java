import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Log;

public class TestCase01 {

    WebDriver driver;
    @BeforeClass
    void SetUp() {
        DOMConfigurator.configure("log4j.xml");
        Log.info("Launch Chrome browser");
        driver = new ChromeDriver();
        Log.info("ChromeDriver was started successfully.");
    }

    @AfterClass
    void TearDown() {
        driver.quit();
        Log.info("Close Chrome browser");
    }

    @Test
    void test() {
        Log.info("Navigate to website");
        driver.get("https://the-internet.herokuapp.com/login");
        Log.info("Enter username");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Log.info("Enter password");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Log.info("Click Login button");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
    }
}
