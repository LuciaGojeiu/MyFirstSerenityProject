package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccount();
        homePage.clickLogin();
    }
    @Step
    public void performLogin(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoggedIn(String userName) {
        Assert.assertTrue(accountPage.isLoggedIn(userName));
    }



}
