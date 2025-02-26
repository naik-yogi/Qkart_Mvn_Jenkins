package automation.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.LoginPage;
import automation.RegisterPage;
import automation.utils.TestDataGenerator;

public class RegisterTest extends BaseTest {
    public static String username = TestDataGenerator.getTimestampUsername();
    public static String password = TestDataGenerator.getPassword();

    @Test(priority = 1)
    public void registerTest() throws InterruptedException{
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");

        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        register.enterUsername(username);
        register.enterPassword(password);
        register.enterConfirmPassword(password);
        register.clickRegisterButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(login.getLoginButton()));

        boolean registrationSuccess = driver.getCurrentUrl().equals("https://crio-qkart-frontend-qa.vercel.app/login");

        // Force fail if registration fails
        if (!registrationSuccess) {
            throw new RuntimeException("Registration Failed! Test should fail.");
        }

        Assert.assertTrue(registrationSuccess, "Registration failed!");
    }
    
}
