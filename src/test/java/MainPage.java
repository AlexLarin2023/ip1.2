import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {


    // Put Logger
    private static Logger logger = LogManager.getLogger(MainPage.class);


    public MainPage(WebDriver driver) {
        super(driver);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private WebElement getSaveYourLoginInfoButton() {
        String saveYourLoginInfoButtoXPath = "//div[@class='x1i10hfl xjqpnuy xa49m3k xqeqjp1 x2hbi6w xdl72j9 x2lah0s xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x2lwn1j xeuugli x1hl2dhg xggy1nq x1ja2u2z x1t137rt x1q0g3np x1lku1pv x1a2a7pz x6s0dn4 xjyslct x1ejq31n xd10rxx x1sy0etr x17r0tee x9f619 x1ypdohk x1i0vuye x1f6kntn xwhw2v2 xl56j7k x17ydfre x2b8uid xlyipyv x87ps6o x14atkfc xcdnw81 xjbqb8w xm3z3ea x1x8b98j x131883w x16mih1h x972fbf xcfux6l x1qhh985 xm0m39n xt0psk2 xt7dq6l xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x1n5bzlp x173jzuc x1yc6y37']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveYourLoginInfoButtoXPath)));
    }

    // Click the "Save Your Login Info" button
    public void clickSaveYourLoginInfo() {
        getSaveYourLoginInfoButton().click();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private int actualLikedCount = 0; // Initialize with 0

    private List<WebElement> getLikeMainPageButtons() {
        return driver.findElements(By.xpath("//span[@class='xp7jhwk']"));
    }

    public void scrollAndLikePosts() {

        // Log the start of the method
        logger.debug("scrollAndLikePosts started.");

        int initialLikeCount = 0;
        int maxLikes = 20;   // Set the maximum number of likes

        while (maxLikes > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='xp7jhwk']")));

            List<WebElement> likeButtons = getLikeMainPageButtons();
            int currentLikeCount = likeButtons.size();

            // Scroll down the page if new like buttons are not visible
            if (currentLikeCount == initialLikeCount) {
                Actions actions = new Actions(driver);
                actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

                continue;
            }

            // Like the new posts
            for (int i = initialLikeCount; i < currentLikeCount && maxLikes > 0; i++) {
                likeButtons.get(i).click();

                maxLikes--;

                actualLikedCount++; // Increment actualLikedCount when a post is liked
            }

            initialLikeCount = currentLikeCount;

            // Scroll down further and repeat the process
            Actions actions = new Actions(driver);
            actions.moveToElement(likeButtons.get(likeButtons.size() - 1)).perform();

            // Wait for some time to allow new content to load
            try {
                Thread.sleep(3000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Log the completion of the method along with the liked post count
        logger.info("scrollAndLikePosts completed. Liked " + getActualLikedCount() + " posts.");
    }

    // Add a method to get the actual number of liked posts
    public int getActualLikedCount() {
        return actualLikedCount;
    }
//////////////////////////////////////////////////////////////////////////////////////

                                        // Only sor Safari

    private WebElement getNotificationButton() {
        String notificationButtonXPath = "//button[@class='_a9-- _a9_1']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationButtonXPath)));
    }

    // Click the "Notification" button
    public void clickNotificationButton() {
        getNotificationButton().click();
    }

//////////////////////////////////////////////////////////////////////////////////////


}








//
//    private WebElement getMyProfileButton() {
//        String myProfileButtonXPath = "//img[@class='xpdipgo x6umtig x1b1mbwd xaqea5y xav7gou xk390pu x5yr21d xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x11njtxf xh8yej3']";
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myProfileButtonXPath)));
//    }
//
//    // Click the "MyProfileButton" button
//    public void clickMyProfileButton() {
//        getMyProfileButton().click();
//    }

