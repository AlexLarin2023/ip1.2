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

        // I keep this data for later
//        username = "Alex_kolesnyk_";
//        password = "Family2022!";

        username = "odessa_mma_team_";
        password = "Mittswork2023!";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexander.anderson\\IdeaProjects\\InstaProject\\chromedriver.exe");

        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Pass the options when initializing ChromeDriver
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
