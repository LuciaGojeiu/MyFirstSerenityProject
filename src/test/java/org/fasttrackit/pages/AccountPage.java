package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/")
public class AccountPage extends PageObject {
    @FindBy(css =".hello strong")
    private WebElementFacade helloText;

    public boolean isLoggedIn(String userName){
        return helloText.containsOnlyText("Hello, " + userName + "!");

    }
}
