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

            // Create an instance of the Stories page (only once per loop iteration)
            Stories stories = new Stories(driver);


            // Click the Second story on the Stories page
            stories.clickSecondStory();

            // Like the current story
            stories.clickLikeButton();

            // Click the "Instagram" button on the main page
            stories.clickCloseButton();


        // Click the third story on the Stories page
        stories.clickThirdStory();

        // Like the current story
        stories.clickLikeButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        // Click the fourth story on the Stories page
        stories.clickFourthStory();

        // Like the current story
        stories.clickLikeButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        // Click the fifth story on the Stories page
        stories.clickFifthStory();

        // Like the current story
        stories.clickLikeButton();

        // Click the "Instagram" button on the main page
        stories.clickCloseButton();


        }
    }

