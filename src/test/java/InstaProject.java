import org.testng.annotations.Test;

public class InstaProject extends BaseTest {

    @Test
    public void performScenarioMultipleTimes() {
        int repeatCount = 5;


            // Create an instance of the login page
            LoginPage loginPage = new LoginPage(driver);

            // Open the Instagram website
            loginPage.open();

            // Perform login and get to the main page
            MainPage mainPage = loginPage.loginToApp(username, password);

            // Click the "Save Your Login Info" button on the main page
            mainPage.clickSaveYourLoginInfo();

            // Create an instance of the Stories page
            Stories stories = new Stories(driver);

            // Call the scrollAndLikePosts method to start scrolling and liking posts
            mainPage.scrollAndLikePosts();

            // Repeat the scenario for the specified number of times
            for (int i = 0; i < repeatCount; i++) {
            // Click the first story on the Stories page
            stories.clickFirstStory();

            // Like the current story
            stories.clickLikeButton();

            // Go back to the main page from the Stories page
            mainPage = stories.goBackToMainPage();

            // Click the "Instagram" button on the main page
            mainPage.clickInstagramButton();

            // Go back to the main page from the Instagram page
            mainPage = stories.goBackToMainPage();


            // Click the "Home" button on the main page
            mainPage.clickHomeButton();

            // Add any necessary waits or further actions
        }
    }
}




