import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // Modified to use dynamic wait time for the email field
    private WebElement getEmailField() {
        By emailBy = By.xpath("//input[@aria-label='Phone number, username, or email']");
        return waitAndReturnElement(emailBy, 30); // Adjust the max wait time as needed
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.xpath("//input[@aria-label='Password']"));
    }

    // Modified to use dynamic wait time for the login button
    private WebElement getLoginButton() {
        return waitAndReturnElement(By.xpath("//button[@class='_acan _acap _acas _aj1-']"), 30); // Adjust the max wait time as needed
    }

    public MainPage loginToApp(String username, String password){
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }
    public void open() {
        driver.get("https://www.instagram.com/");
    }
}
