package automation.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage"); // Prevents resource issues
        options.addArguments("--no-sandbox"); // Needed for some Linux/Windows environments
        options.addArguments("--disable-gpu"); // Helps in headless mode
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-extensions"); // Prevents extension conflicts
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars"); // Hides "Chrome is being controlled" bar
        //options.addArguments("--headless=new"); // Run without GUI (Optional, for debugging)

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
