import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stories extends BasePage {
    public Stories(WebDriver driver) {
        super(driver);
    }
    private WebElement getCloseButton() {
        By closeButtonBy = By.xpath("//*[@aria-label='Close']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonBy));
    }

    public void clickCloseButton() {
        getCloseButton().click();
    }



    // Get the second story element
    private WebElement getSecondStory() {
        By secondStoryBy = By.xpath("(//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o'])[2]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(secondStoryBy));
    }

    // Click the second story
    public void clickSecondStory() {
        WebElement secondStory = getSecondStory();
        if (secondStory.isDisplayed()) {
            secondStory.click();
            // You can add waits here if necessary
        } else {
            System.out.println("Second story button not found.");
        }
    }


    // Get the Third story element
    private WebElement getThirdStory() {
        By thirdStoryBy = By.xpath("(//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o'])[3]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thirdStoryBy));
    }

    // Click the Third story
    public void clickThirdStory() {
        WebElement thirdStory = getThirdStory();
        if (thirdStory.isDisplayed()) {
            thirdStory.click();
            // You can add waits here if necessary
        } else {
            System.out.println("Third story button not found.");
        }
    }



    // Get the fourth story element
    private WebElement getFourthStory() {
        By fourthStoryBy = By.xpath("(//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o'])[4]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fourthStoryBy));
    }

    // Click the fourth story
    public void clickFourthStory() {
        WebElement fourthStory = getFourthStory();
        if (fourthStory.isDisplayed()) {
            fourthStory.click();
            // You can add waits here if necessary
        } else {
            System.out.println("Fourth story button not found.");
        }
    }


    // Get the fifth story element
    private WebElement getFifthStory() {
        By fifthStoryBy = By.xpath("(//div[@class='x9f619 x1lliihq x6ikm8r x10wlt62 x1n2onr6 x2b8uid xlyipyv xuxw1ft x1yf5rgg xhikscq xg83lxy x1h0ha7o'])[5]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fifthStoryBy));
    }

    // Click the fifth story
    public void clickFifthStory() {
        WebElement fifthStory = getFifthStory();
        if (fifthStory.isDisplayed()) {
            fifthStory.click();
            // You can add waits here if necessary
        } else {
            System.out.println("Fifth story button not found.");
        }
    }


    // Get the like button element of a story
    private WebElement getLikeButton() {
        By likeButtonBy = By.xpath("//div[@class='_abx4']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(likeButtonBy));
    }

    // Click the like button on the story
    public void clickLikeButton() {
        WebElement likeButton = getLikeButton();
        if (likeButton.isDisplayed()) {
            likeButton.click();
            // Wait for a short time after clicking the like button
            try {
                Thread.sleep(5000); // Adjust sleep time as needed
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
