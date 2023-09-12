import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stories extends BasePage {
    public Stories(WebDriver driver) {
        super(driver);
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

    // Get the right arrow element
    private WebElement getRightArrow() {
        By rightArrowBy = By.xpath("//div[@class=' _9zm2']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightArrowBy));
    }

    // Click the right arrow a specified number of times
    public void clickRightArrow(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            getRightArrow().click();
        }
    }

    // Perform the scenario of clicking right arrow 5 times and then clicking like story button once
    public void swipeFiveTimesAndLikeOneTime(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            clickRightArrow(5); // Click right arrow 5 times
            clickLikeStoryButton(); // Click like story button 1 time
        }
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    private WebElement getShopNowButton() {
//        String loginInfoXPath = "_aacl _aaco _aacw _aad2 _aad6 _aadb";
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginInfoXPath)));
//    }
//
//
//    public void clickShopNowButton() {
//        getShopNowButton().click();
//    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////