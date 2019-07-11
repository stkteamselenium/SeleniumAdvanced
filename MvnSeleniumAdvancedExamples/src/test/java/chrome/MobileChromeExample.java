package chrome;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MobileChromeExample {
	 
    private static WebDriver driver;
    private static WebDriverWait wait ; 
 /**
  * jose a galvan
  */
    @BeforeClass
    public static void setup () {
        //Chrome Driver Decleration
      //  wait = new WebDriverWait(driver,10);
    	
        String chromeDriverLocation = "src/test/resources/drivers/chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
 
        //Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
         // emulation();
    }
 
    @Test
    public void mobileWebTestChrome () throws InterruptedException {
        //Go To Amazon.com
        driver.navigate().to("https://www.coppel.com/");
        Thread.sleep(5000);
        //Get search bar and search button
        WebElement searchBar = driver.findElement(By.id("SimpleSearchForm_SearchTerm"));
        WebElement searchButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
 
        //Write Sony Headphones to the search bar and click search button
        searchBar.sendKeys("Sony");
        searchButton.click();
        Thread.sleep(10000);
        //Wait until first element image is visible
 //       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='AT&T Sony Xperia XA Lima']/following::a[contains(@id,'add2CartBtn')][1]")));

        //Get first element's text and write it to the console
        String firstSearchElementText = driver.findElement(By.xpath("//*[text()='AT&T Sony Xperia XA Lima']")).getText();
        System.out.println("First Search Element Name: " + firstSearchElementText);
    }
 
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
    
  public static void emulation(){
//
	  Map<String, Object> deviceMetrics = new HashMap<>();
	  deviceMetrics.put("width", 360);
	  deviceMetrics.put("height", 640);
	  deviceMetrics.put("pixelRatio", 3.0);

	  Map<String, Object> mobileEmulation = new HashMap<>();
	  mobileEmulation.put("deviceMetrics", deviceMetrics);
	  mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	  driver = new ChromeDriver(chromeOptions);
  }
  
  
}