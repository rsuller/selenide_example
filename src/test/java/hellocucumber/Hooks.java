package hellocucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.java.Log;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log
public class Hooks {

    @Before
    public void setUpTestEnvironment() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("environment.properties");
        properties.load(input);

        // Set up browser
        String browser = properties.getProperty("browser");
        if ("chrome".equals(browser)) {
            WebDriverRunner.setWebDriver(new ChromeDriver());
            log.info(String.format("Running tests using %s browser", browser));
        }

        Configuration.reportsFolder = "target/surefire-reports";
        getWebDriver().manage().window().maximize();
    }

    @After
    public void closeDriver() {
        getWebDriver().quit();
    }
}
