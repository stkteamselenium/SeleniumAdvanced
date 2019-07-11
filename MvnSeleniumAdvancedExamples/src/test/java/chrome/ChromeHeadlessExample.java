package chrome;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
/** Referencia
 * https://dzone.com/articles/running-selenium-tests-with-chrome-headless
 * @author Antonio Galvan
 *
 */
public class ChromeHeadlessExample {
    @Test
    public void testExecution() throws IOException {
        try {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        // Add options to Google Chrome. The window-size is important for responsive sites
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://seleniumhq.org");
		Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        // a guarantee that the test was really executed
        assertTrue(driver.findElement(By.id("q")).isDisplayed());
        driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.getMessage());
		}
    }
}