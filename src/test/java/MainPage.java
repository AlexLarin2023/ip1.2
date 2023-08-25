import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getHomeButton() {
        By homeBy = By.xpath("//div[@class='w-0u']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBy));
        return driver.findElement(homeBy);
    }

    private List<WebElement> getLikeButtons() {
        return driver.findElements(By.xpath("//span[text()='Like']"));
    }

    public void scrollAndLikePosts() {
        int initialLikeCount = 0;
        int maxScrolls = 10; // Set the maximum number of scrolls
        int maxLikes = 20;   // Set the maximum number of likes

        while (maxScrolls > 0 && maxLikes > 0) {
            List<WebElement> likeButtons = getLikeButtons();
            int currentLikeCount = likeButtons.size();

            // Scroll down the page if new like buttons are not visible
            if (currentLikeCount == initialLikeCount) {
                Actions actions = new Actions(driver);
                actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

                // Wait for some time to allow new content to load
                try {
                    Thread.sleep(2000); // Adjust sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maxScrolls--;
                continue;
            }

            // Like the new posts
            for (int i = initialLikeCount; i < currentLikeCount && maxLikes > 0; i++) {
                likeButtons.get(i).click();
                // Wait for a short time after clicking the like button
                try {
                    Thread.sleep(1000); // Adjust sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                maxLikes--;
            }

            initialLikeCount = currentLikeCount;

            // Scroll down further and repeat the process
            Actions actions = new Actions(driver);
            actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

            // Wait for some time to allow new content to load
            try {
                Thread.sleep(2000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maxScrolls--;
        }
    }

    public boolean isMainPage() {
        try {
            return getHomeButton().isDisplayed();
        } catch (TimeoutException err) {
            return false;
        }
    }
}