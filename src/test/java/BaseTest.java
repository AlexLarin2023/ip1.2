import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected String username;
    protected String password;

    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected Stories stories;


    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexander.anderson\\IdeaProjects\\InstaProject\\chromedriver.exe");
    }

    @BeforeMethod
    public void startUp() {

        // Set Chrome options to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Pass the options when initializing ChromeDriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // I keep this data for later
        username = "Alex_kolesnyk_";
        password = "Family2022!";

////         this data for now
//        username = "odessa_mma_team_";
//        password = "Mittswork2023!";


        // Initialize the login page and navigate to it
        loginPage = new LoginPage(driver);
        loginPage.open();

        // Perform login and get to the main page
        mainPage = loginPage.loginToApp(username, password);

        // Click the "Save Your Login Info" button on the main page
        mainPage.clickSaveYourLoginInfo();

        // Initialize the Stories page (only once)
        stories = new Stories(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}