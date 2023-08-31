import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stories extends BasePage {
    public Stories(WebDriver driver) {
        super(driver);
    }

    // Get the first story element
    private WebElement getFirstStory() {
        By firstStoryBy = By.xpath("//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstStoryBy));
    }

    // Click the first story
    public void clickFirstStory() {
        WebElement firstStory = getFirstStory();
        if (firstStory.isDisplayed()) {
            firstStory.click();
            // You can add waits here if necessary
        } else {
            System.out.println("First story button not found.");
        }
    }

    // Get the like button element of a story
    private WebElement getLikeButton() {
        By likeButtonBy = By.xpath("(//*[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k'])[4]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(likeButtonBy));
    }

    // Click the like button on the story
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

    // Go back to the main page from the Stories page
    public MainPage goBackToMainPage() {
        driver.navigate().back();
        return new MainPage(driver);
    }
}
