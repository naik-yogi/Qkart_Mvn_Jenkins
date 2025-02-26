package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//button[text()='Register Now']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        userNameTextBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordTextBox.sendKeys(password);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
}
