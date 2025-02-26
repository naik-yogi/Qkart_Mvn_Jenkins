package automation.tests;

import automation.HomePage;
import automation.LoginPage;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {

    @Test(priority = 2, dependsOnMethods = { "automation.tests.RegisterTest.registerTest" }, alwaysRun = false)
    public void testLogin() throws InterruptedException {
        driver.get("https://crio-qkart-frontend-qa.vercel.app/login"); // Change this to your app URL
        test.log(Status.INFO, "Navigated to Login Page");
        
        LoginPage loginPage = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        loginPage.enterUsername(RegisterTest.username);
        test.log(Status.INFO, "Entered the username:" + RegisterTest.username);
        loginPage.enterPassword(RegisterTest.password);
        loginPage.clickLogin();
        test.log(Status.INFO, "Entered Credentials & Clicked Login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.getLogoutbutton()));

        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://crio-qkart-frontend-qa.vercel.app/", "Login failed!");
            test.log(Status.PASS, "Login Successful");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Login Failed: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("LoginTest"));
            throw e;
        }
        
   
    }
}
