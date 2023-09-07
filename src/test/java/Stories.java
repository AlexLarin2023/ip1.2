import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stories extends BasePage {
    public Stories(WebDriver driver) {
        super(driver);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    private WebElement getCloseButton() {
        By closeButtonBy = By.xpath("//*[@aria-label='Close']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonBy));
    }

    public void clickCloseButton() {
        getCloseButton().click();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Get the like button element of a story
    private WebElement getLikeButton() {
        By likeButtonBy = By.xpath("//div[@class='_abx4']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(likeButtonBy));
    }

    // Click the like button on the story
    public void clickLikeStoryButton() {
        WebElement likeButton = getLikeButton();
        if (likeButton.isDisplayed()) {
            likeButton.click();
        } else {
            System.out.println("Like button not found.");
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private WebElement getRightArrow() {
        By rightArrowBy = By.xpath("//div[@class=' _9zm2']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightArrowBy));
    }

    public void clickRightArrow(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            getRightArrow().click();
        }
    }


}