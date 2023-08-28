import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //    // Assert of the main page

//    private WebElement getHomeButton() {
//        By homeBy = By.xpath("//div[@class='w-0u']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBy));
//        return driver.findElement(homeBy);
//    }

//    public boolean isMainPage() {
//        try {
//            return getHomeButton().isDisplayed();
//        } catch (TimeoutException err) {
//            return false;
//        }
//    }

    private WebElement getSaveYourLoginInfoButton() {
        String loginInfoXPath = "//div[@class='x1i10hfl xjqpnuy xa49m3k xqeqjp1 x2hbi6w xdl72j9 x2lah0s xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x2lwn1j xeuugli x1hl2dhg xggy1nq x1ja2u2z x1t137rt x1q0g3np x1lku1pv x1a2a7pz x6s0dn4 xjyslct x1ejq31n xd10rxx x1sy0etr x17r0tee x9f619 x1ypdohk x1i0vuye x1f6kntn xwhw2v2 xl56j7k x17ydfre x2b8uid xlyipyv x87ps6o x14atkfc xcdnw81 xjbqb8w xm3z3ea x1x8b98j x131883w x16mih1h x972fbf xcfux6l x1qhh985 xm0m39n xt0psk2 xt7dq6l xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x1n5bzlp x173jzuc x1yc6y37']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginInfoXPath)));
    }

    // Click the "Save Your Login Info" button
    public void clickSaveYourLoginInfo() {
        getSaveYourLoginInfoButton().click();
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
}