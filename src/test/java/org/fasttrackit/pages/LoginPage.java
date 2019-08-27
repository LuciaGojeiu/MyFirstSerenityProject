package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/login/")
public class LoginPage extends PageObject {
    @FindBy(id = "email")
    private WebElementFacade emailField;
    @FindBy(id = "pass")
    private WebElementFacade passField;
    @FindBy(id = "send2")
    private WebElementFacade loginButton;
    @FindBy(css = ".error-msg span")
    private WebElementFacade errorLoginMessage;

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPassField(String pass) {
        typeInto(passField, pass);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void verifyNotLoggedIn() {
        errorLoginMessage.shouldContainText("Invalid login or password.");
    }
}
