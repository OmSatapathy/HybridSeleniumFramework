package uitests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Basetest {

    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        // Detect if running in CI
        boolean isCI = System.getenv("CI") != null;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (isCI) {
            	options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            } else {
                System.out.println("Running locally → Headed mode");
            }

            driver = new ChromeDriver(options);
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            if (isCI) {
                options.addArguments("-headless");
            }

            driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}