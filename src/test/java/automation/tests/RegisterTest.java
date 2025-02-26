package automation.tests;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import automation.LoginPage;
import automation.RegisterPage;
import automation.utils.TestDataGenerator;

public class RegisterTest extends BaseTest {
    public static ThreadLocal<String> username = new ThreadLocal<>();
    public static String password = TestDataGenerator.getPassword();

    @Test(priority = 1)
    public void registerTest() throws InterruptedException {
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");
        test.log(Status.INFO, "Navigated to Registration Page");

        // Generate and store a unique username for this thread/browser
        username.set(TestDataGenerator.getRandomUUIDUsername());

        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        register.enterUsername(username.get());
        test.log(Status.INFO, "Entered the username:" + username.get());
        register.enterPassword(password);
        register.enterConfirmPassword(password);
        register.clickRegisterButton();
        test.log(Status.INFO, "Clicked on Register Button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(login.getLoginButton()));

        // Verification
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://crio-qkart-frontend-qa.vercel.app/login",
                    "Registration failed!");
            test.log(Status.PASS, "Registration Successful");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Registration Failed: " + e.getMessage());
            test.addScreenCaptureFromPath(captureScreenshot("RegisterTest"));
            throw e;
        }
    }

}
