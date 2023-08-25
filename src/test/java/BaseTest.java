import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String username;
    protected String password;

    @BeforeMethod
    public void startUp() {
        username = "infokolesnik@gmail.com";
        password = "Eyecontact2021!";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexander.anderson\\IdeaProjects\\instagram\\chromedriver.exe");

        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Pass the options when initializing ChromeDriver
        driver = new ChromeDriver(options);
    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
}
