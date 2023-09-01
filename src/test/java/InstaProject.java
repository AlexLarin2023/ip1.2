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

        int repeatCount = 5;
        // Repeat the scenario for the specified number of times
        for (int i = 0; i < repeatCount; i++) {
            // Create an instance of the Stories page (only once per loop iteration)
            Stories stories = new Stories(driver);

            // Click the first story on the Stories page
            stories.clickFirstStory();

            // Like the current story
            stories.clickLikeButton();

            // Click the "Instagram" button on the main page
            stories.clickInstagramButton();

            // Click the "Home" button on the main page
            mainPage.clickHomeButton();
        }
    }
}
