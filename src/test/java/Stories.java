import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stories extends BasePage {
    public Stories(WebDriver driver) {
        super(driver);
    }

    // Gets the first story element
    private WebElement getFirstStory() {
        String firstStoryXPath = "//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstStoryXPath)));
    }

    // Clicks the first story
    public void clickFirstStory() {
        WebElement firstStory = getFirstStory();
        if (firstStory.isDisplayed()) {
            firstStory.click();
            // Wait for some time for the content to load, if needed
        } else {
            System.out.println("First story button not found.");
        }
    }

    // Gets the next story button element
    private WebElement getNextStoryButton() {
        String nextStoryXPath = "//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextStoryXPath)));
    }

    // Gets the next right item element for navigation
    private WebElement getNextRightItem() {
        return driver.findElement(By.xpath("//div[@class='_ac07']"));
    }

    // Gets the like button element
    private WebElement getLikeButton() {
        String likeButtonXPath = "//div[@class='_abx4']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(likeButtonXPath)));
    }

    // Clicks the like button
    public void clickLikeButton() {
        WebElement likeButton = getLikeButton();
        if (likeButton.isDisplayed()) {
            likeButton.click();
            // Wait for a short time after clicking the like button
            try {
                Thread.sleep(1000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Like button not found.");
        }
    }

    // Clicks the next story if present
    public void clickNextStoryIfPresent() {
        WebElement nextStoryButton = getNextStoryButton();
        if (nextStoryButton.isDisplayed()) {
            nextStoryButton.click();
            // Wait for some time for the content to load, if needed
        } else {
            System.out.println("Next story button not found.");
        }
    }

    // Clicks the next right item to navigate to the next story
    public void clickNextRightItem() {
        WebElement nextRightItem = getNextRightItem();
        if (nextRightItem.isDisplayed()) {
            nextRightItem.click();
            // Wait for some time for the content to load, if needed
        } else {
            System.out.println("Next right item not found.");
        }
    }

    // Likes stories and navigates through them a specified number of times
    public void likeAndNavigateThroughStories(int numberOfLikes) {
        int likesCount = 0;

        while (likesCount < numberOfLikes) {
            if (isLikeButtonPresent()) {
                clickLikeButton();
                likesCount++;
            }
            clickNextRightItem(); // Click on the next right item to navigate
        }
    }

    // Checks if the like button is present
    private boolean isLikeButtonPresent() {
        try {
            return getLikeButton().isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
