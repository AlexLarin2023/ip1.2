import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstaProject extends BaseTest {

    @Test
    public void likePosts() {

        // Call the scrollAndLikePosts method to start scrolling and liking posts
        mainPage.scrollAndLikePosts();

        // Get the actual number of likes after scrolling and liking posts
        int actualLikes = mainPage.getActualLikedCount();

        // Check if the actualLikes count is equal to the expected maxLikes
        int expectedMaxLikes = 20; // Set the expected maximum number of likes
        Assert.assertEquals(actualLikes, expectedMaxLikes, "The actual number of likes does not match the expected maximum likes.");
    }
    @Test
    public void likeStoriesSwipe() {

        // Click the Second story on the Stories page
        mainPage.clickSecondStory();

        // Like the current story
        stories.clickLikeStoryButton();
        // Use XPath to locate the element representing the "Liked" state
        WebElement likedStateElement = driver.findElement(By.xpath("//*[@aria-label='Unlike']"));
        // Assert that the element representing the "Liked" state is displayed
        Assert.assertTrue(likedStateElement.isDisplayed(), "The 'Liked' state element is not displayed after clicking");

        // Swipe
        stories.swipeFiveTimesAndLikeOneTime(10);
    }
}




//    @Test
//    public void likeFriendsPhotos(){
//
//        mainPage.clickMyProfileButton();
//        myProfilePage.clickFollowingButton();
//        myProfilePage.clickFriendButton();
//        friendsProfile.clickFriendsPicture();
//
//
//    }