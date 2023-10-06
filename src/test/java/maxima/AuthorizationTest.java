package maxima;

import maxima.helper.ActionFunctionInterface;
import maxima.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {


    @DataProvider(name = "testAuthorization")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"aqa_02", "769827", (ActionFunctionInterface) () -> LoginPage.checkIconIsVisible()},
        };
    }

    @Test(dataProvider = "testAuthorization", testName = "Проверка авторизации на сайт")
    public void checkJoinSait(String login, String password, ActionFunctionInterface func) {
        LOG.info("Вводим логин и пароль на сайт и авторизуемся");
        LoginPage.attemptLogin(login, password);
        func.apply();
    }
}
