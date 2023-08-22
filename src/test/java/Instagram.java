import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Instagram {
    @Test
    public void openGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexander.anderson\\IdeaProjects\\instagram\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");
    }
}
