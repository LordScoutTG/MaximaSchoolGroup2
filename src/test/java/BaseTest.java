import helper.ScreenshotListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import helper.WebDriverContainer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
@Listeners(ScreenshotListener.class)

public class BaseTest {

        protected Logger LOG = Logger.getLogger(String.valueOf(BaseTest.class));
        public WebDriver driver;

        @BeforeMethod(description = "Вход на сайт")
        public void beforeTest() throws IOException {
            driver = WebDriverContainer.getDriver();
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("locators.properties"));
            driver.get(System.getProperty("URL"));
            driver.manage().window().setSize(new Dimension(1980, 1020));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @AfterMethod(description = "Закрываем браузер")
        public void afterTest() {
            WebDriverContainer.close();
        }
    }

