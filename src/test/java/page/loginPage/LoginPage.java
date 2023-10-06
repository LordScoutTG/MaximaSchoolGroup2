package page.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    private final By inputLogin = By.cssSelector("");
    private final By inputPassword = By.cssSelector("");
    private final By buttonJoin = By.cssSelector("");
    private final By iconAccount = By.cssSelector("");


    private final String initialWindow;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initialWindow = driver.getWindowHandle();
    }

    private void setLogin(String login) {
        driver.findElement(inputLogin).sendKeys(login);
    }

    private void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(buttonJoin).click();
    }

    public void attemptLogin(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickLoginButton();
    }
    public void checkIconIsVisible() {
        driver.findElement(iconAccount).isDisplayed();
    }
}

