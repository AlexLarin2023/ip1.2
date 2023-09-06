import org.testng.annotations.Test;

public class InstaProject extends BaseTest {

    @Test
    public void likePosts() {
        // Create an instance of the login page
        LoginPage loginPage = new LoginPage(driver);

        // Open the Instagram website
        loginPage.open();

        // Perform login and get to the main page
        MainPage mainPage = loginPage.loginToApp(username, password);

        // Click the "Save Your Login Info" button on the main page
        mainPage.clickSaveYourLoginInfo();

        // Call the scrollAndLikePosts method to start scrolling and liking posts
        mainPage.scrollAndLikePosts();
    }

    @Test
    public void likeStories() {
        // Create an instance of the login page
        LoginPage loginPage = new LoginPage(driver);

        // Open the Instagram website
        loginPage.open();

        // Perform login and get to the main page
        MainPage mainPage = loginPage.loginToApp(username, password);

        // Click the "Save Your Login Info" button on the main page
        mainPage.clickSaveYourLoginInfo();

        // Click the Second story on the Stories page
        mainPage.clickSecondStory() ;

        // Create an instance of the Stories page (only once per loop iteration)
        Stories stories = new Stories(driver);

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        // Click the third story on the Stories page
        mainPage.clickThirdStory();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        // Click the fourth story on the Stories page
        mainPage.clickFourthStory();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        // Click the fifth story on the Stories page
        mainPage.clickFifthStory();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();
    }

    @Test
    public void likeStoriesSwipe() {
        // Create an instance of the login page
        LoginPage loginPage = new LoginPage(driver);

        // Open the Instagram website
        loginPage.open();

        // Perform login and get to the main page
        MainPage mainPage = loginPage.loginToApp(username, password);

        // Click the "Save Your Login Info" button on the main page
        mainPage.clickSaveYourLoginInfo();

        // Click the Second story on the Stories page
        mainPage.clickSecondStory();

        // Create an instance of the Stories page
        Stories stories = new Stories(driver);

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the image on right
        stories.clickSecondImageOnRight();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the image on right
        stories.clickThirdImageOnRight();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the image on right
        stories.clickFourthImageOnRight();

        // Like the current story
        stories.clickLikeStoryButton();

        // Click the image on right
        stories.clickFifthImageOnRight();

        // Like the current story
        stories.clickLikeStoryButton();

    }
}
