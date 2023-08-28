import org.testng.Assert;
import org.testng.annotations.Test;

public class InstaProject extends BaseTest {


    // Positive testing
    @Test
    public void loginTest_loginWithCorrectCredentials_mainPageOpened(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);

        //    // Assert of the main page
//        Assert.assertTrue(mainPage.isMainPage());

        // Click the "Save Your Login Info" button
        mainPage.clickSaveYourLoginInfo();

        // Call the scrollAndLikePosts method to start scrolling and liking posts
        mainPage.scrollAndLikePosts();
    }
}
