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





    private WebElement getSecondImageOnRight() {
        By secondImageOnRightBy = By.xpath("(//div[@class='_ac07'])[2]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(secondImageOnRightBy));
    }

    public void clickSecondImageOnRight() {
        getSecondImageOnRight().click();
    }

     private WebElement getThirdImageOnRight() {
        By thirdImageOnRightBy = By.xpath("(//div[@class='_ac07'])[3]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thirdImageOnRightBy));
    }

    public void clickThirdImageOnRight() {
        getThirdImageOnRight().click();
    }

    private WebElement getFourthImageOnRight() {
        By fourthImageOnRightBy = By.xpath("(//div[@class='_ac07'])[4]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fourthImageOnRightBy));
    }

    public void clickFourthImageOnRight() {
        getFourthImageOnRight().click();
    }


     private WebElement getFifthImageOnRight() {
        By fifthImageOnRightBy = By.xpath("(//div[@class='_ac07'])[5]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fifthImageOnRightBy));
    }

    public void clickFifthImageOnRight() {
        getFifthImageOnRight().click();
    }

}