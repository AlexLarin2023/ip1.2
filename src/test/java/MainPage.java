import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getSaveYourLoginInfoButton() {
        By loginInfoXPath = By.xpath("//button[text()='Save Your Login Info']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginInfoXPath));
    }


    // Click the "Save Your Login Info" button
    public void clickSaveYourLoginInfo() {
        getSaveYourLoginInfoButton().click();
    }



    // Like a post
    private List<WebElement> getLikeButtons() {
        return driver.findElements(By.xpath("//span[@class='xp7jhwk']"));
    }


    // Scroll down the page
    private void scrollDown() {
        Actions actions = new Actions(driver);
        List<WebElement> likeButtons = getLikeButtons();

        // Scroll down the page
        actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

        // Use an explicit wait for new content to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration.ofSeconds

        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[@class='xp7jhwk']"), likeButtons.size()));
        } catch (org.openqa.selenium.TimeoutException e) {
            // Handle the timeout exception if needed
        }
    }

    public void scrollAndLikePosts() {
        int initialLikeCount = 0;
        int maxScrolls = 10; // Set the maximum number of scrolls
        int maxLikes = 20;   // Set the maximum number of likes

        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);

        while (maxScrolls > 0 && maxLikes > 0) {
            List<WebElement> likeButtons = getLikeButtons();
            int currentLikeCount = likeButtons.size();

            if (currentLikeCount > 0) {
                for (int i = initialLikeCount; i < currentLikeCount && maxLikes > 0; i++) {
                    likeButtons.get(i).click();
                    // Use an explicit wait for the like action to complete (if needed)
                    maxLikes--;
                }
                initialLikeCount = currentLikeCount;
            } else {
                // Scroll down the page if no new like buttons are visible
                scrollDown();
                maxScrolls--;
            }
        }
    }
}
