import helper.ActionFunctionInterface;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.loginPage.LoginPage;

public class AuthorizationTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void init() {
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "testAuthorization")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"aqa_02", "769827", (ActionFunctionInterface) () -> loginPage.checkIconIsVisible()},
        };
    }

    @Test(dataProvider = "testAuthorization", testName = "Проверка авторизации на сайт")
    public void checkJoinSait(String login, String password, ActionFunctionInterface func) {
        LOG.info("Вводим логин и пароль на сайт и авторизуемся");
        loginPage.attemptLogin(login, password);
        func.apply();
    }
}
