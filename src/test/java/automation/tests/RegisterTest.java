package automation.tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.RegisterPage;

public class RegisterTest extends BaseTest {
    String username="51yogi65443";
    String password="Yogi@3241";

    @Test(priority = 1)
    public void registerTest() throws InterruptedException{
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");

        RegisterPage register = new RegisterPage(driver);
        register.enterUsername(username);
        register.enterPassword(password);
        register.enterConfirmPassword(password);
        
        Thread.sleep(Duration.ofSeconds(5));
        register.clickRegisterButton();
        Thread.sleep(Duration.ofSeconds(15));

        boolean registrationSuccess = driver.getCurrentUrl().equals("https://crio-qkart-frontend-qa.vercel.app/login");

        // Force fail if registration fails
        if (!registrationSuccess) {
            throw new RuntimeException("Registration Failed! Test should fail.");
        }

        Assert.assertTrue(registrationSuccess, "Registration failed!");
        //Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Registration failed");

        //Assert.assertEquals(driver.getCurrentUrl(), "https://crio-qkart-frontend-qa.vercel.app/login", "Registration failed");
    }
    
}
