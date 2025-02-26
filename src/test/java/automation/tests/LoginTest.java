package automation.tests;

import automation.LoginPage;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 2, dependsOnMethods = { "automation.tests.RegisterTest.registerTest" }, alwaysRun = false)
    public void testLogin() throws InterruptedException {
        driver.get("https://crio-qkart-frontend-qa.vercel.app/login"); // Change this to your app URL
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(RegisterTest.username);
        loginPage.enterPassword(RegisterTest.password);
        Thread.sleep(Duration.ofSeconds(5));
        loginPage.clickLogin();
        Thread.sleep(Duration.ofSeconds(15));
        Assert.assertEquals(driver.getCurrentUrl(), "https://crio-qkart-frontend-qa.vercel.app/", "Login failed!");
        
   
    }
}
