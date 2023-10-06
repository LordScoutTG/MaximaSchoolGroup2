package maxima.pages;

import org.openqa.selenium.By;
import maxima.TestBase;

import static maxima.helper.WebDriverContainer.setDriver;

public class LoginPage extends TestBase {
    private static final By inputLogin = By.cssSelector("[type=\"text\"]");
    private static final By inputPassword = By.id(":r1:");
    private static final By buttonJoin = By.xpath("//button[text()=\"Войти\"]");
    private static final By iconAccount = By.xpath("//h2[text()=\"Добро пожаловать!\"]");


    private static void setLogin(String login) {
        setDriver().findElement(inputLogin).sendKeys(login);
    }

    private static void setPassword(String password) {
        setDriver().findElement(inputPassword).sendKeys(password);
    }

    private static void clickLoginButton() {
        setDriver().findElement(buttonJoin).click();
    }

    public static void attemptLogin(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickLoginButton();
    }
    public static void checkIconIsVisible() {
        setDriver().findElement(iconAccount).isDisplayed();
    }
}

