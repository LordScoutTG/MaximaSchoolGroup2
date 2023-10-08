package maxima;

import maxima.helper.ScreenshotListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import maxima.helper.WebDriverContainer;

import java.io.IOException;
import java.util.logging.Logger;

@Listeners(ScreenshotListener.class)
public class TestBase {

    public static Logger LOG = Logger.getLogger(String.valueOf(TestBase.class));


    @BeforeMethod(description = "Вход на сайт")
    public void beforeTest() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("locators.properties"));
        WebDriverContainer.setDriver().get(System.getProperty("URL"));
    }

    @AfterMethod(description = "Закрываем браузер")
    public void afterTest() {
        WebDriverContainer.close();
    }
}

