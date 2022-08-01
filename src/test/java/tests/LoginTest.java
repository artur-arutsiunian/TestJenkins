package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.LoginPageObject.Login;
import org.junit.Test;

@Epic("Test for login")
public class LoginTest extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Input in field"),@Feature(value = "Login button")})
    @DisplayName("Check login in app")
    @Description("We check login method and make sure login is completed")
    @Step("Starting test 'testLoginOnStartPage'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testLoginOnStartPage() throws InterruptedException{
        Login Login = new Login(driver);
        Login.loginMethod();
    }
}