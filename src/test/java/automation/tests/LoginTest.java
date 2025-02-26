package automation.tests;

import automation.HomePage;
import automation.LoginPage;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 2, dependsOnMethods = { "automation.tests.RegisterTest.registerTest" }, alwaysRun = false)
    public void testLogin() throws InterruptedException {
        driver.get("https://crio-qkart-frontend-qa.vercel.app/login"); // Change this to your app URL
        
        LoginPage loginPage = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        loginPage.enterUsername(RegisterTest.username);
        loginPage.enterPassword(RegisterTest.password);
        loginPage.clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.getLogoutbutton()));
        Assert.assertEquals(driver.getCurrentUrl(), "https://crio-qkart-frontend-qa.vercel.app/", "Login failed!");
        
   
    }
}
