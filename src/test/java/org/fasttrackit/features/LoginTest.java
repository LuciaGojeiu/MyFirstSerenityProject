package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void invalidLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, "aaaaaaa");
        loginSteps.checkNotLoggedIn();
    }
}
