import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToApp extends BaseTest {


    // Positive testing
    @Test
    public void loginTest_loginWithCorrectCredentials_mainPageOpened(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
//        Assert.assertTrue(mainPage.isMainPage());

        // Call the scrollAndLikePosts method to start scrolling and liking posts
        mainPage.scrollAndLikePosts();
    }
}
