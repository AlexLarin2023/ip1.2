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
<<<<<<< HEAD
        return driver.findElements(By.xpath("//*[@class='xp7jhwk']"));
=======
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
>>>>>>> origin/main
    }

    public void scrollAndLikePosts() {
        int initialLikeCount = 0;
        int maxScrolls = 10; // Set the maximum number of scrolls
        int maxLikes = 20;   // Set the maximum number of likes

        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);

        while (maxScrolls > 0 && maxLikes > 0) {
            // Wait for the like button to be visible before proceeding
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='xp7jhwk']")));

            List<WebElement> likeButtons = getLikeButtons();
            int currentLikeCount = likeButtons.size();

<<<<<<< HEAD
            // Scroll down the page if new like buttons are not visible
            if (currentLikeCount == initialLikeCount) {
                Actions actions = new Actions(driver);
                actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();
=======
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
>>>>>>> origin/main
                maxScrolls--;
            }
<<<<<<< HEAD

            // Like the new posts
            for (int i = initialLikeCount; i < currentLikeCount && maxLikes > 0; i++) {
                WebElement likeButton = likeButtons.get(i);

                likeButton.click();

                maxLikes--;
            }

            initialLikeCount = currentLikeCount;

            // Scroll down further and repeat the process
            Actions actions = new Actions(driver);
            actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

//            // Wait for some time to allow new content to load

            try {
                Thread.sleep(3000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maxScrolls--;
=======
>>>>>>> origin/main
        }
    }
}
