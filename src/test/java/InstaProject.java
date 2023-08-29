import org.testng.annotations.Test;

public class InstaProject extends BaseTest {

    @Test
    public void loginTest_loginWithCorrectCredentials_mainPageOpened(){
        // Login to the app
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);

        // Click the "Save Your Login Info" button
        mainPage.clickSaveYourLoginInfo();

        // Create an instance of the Stories class and click the first story
        Stories stories = new Stories(driver);
        stories.clickFirstStory();

        // Like and navigate through stories
        stories.likeAndNavigateThroughStories(10);
    }
}
