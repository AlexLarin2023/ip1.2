import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an initial wait time
    }

    // Add a method to dynamically adjust wait time
    protected WebElement waitAndReturnElement(By locator, int maxWaitInSeconds) {
        long startTime = System.currentTimeMillis();
        WebElement element = wait
                .pollingEvery(Duration.ofMillis(500)) // Poll every 500 milliseconds
                .withTimeout(Duration.ofSeconds(maxWaitInSeconds)) // Set the maximum wait time
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        long elapsedTime = System.currentTimeMillis() - startTime;
        int remainingWaitInSeconds = maxWaitInSeconds - (int) (elapsedTime / 1000);

        // If the element is found before the max wait time, adjust the wait for future waits
        if (remainingWaitInSeconds > 0) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(remainingWaitInSeconds));
        } else {
            // Reset to the initial wait time if the maximum wait time is exceeded
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return element;
    }
}
