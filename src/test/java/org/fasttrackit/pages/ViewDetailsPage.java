package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ViewDetailsPage extends PageObject {

    @FindBy(css = ".swatch-label img")
    private WebElementFacade productColor;
    @FindBy(css = ".option-m .swatch-label")
    private WebElementFacade product1Size;
    @FindBy(css = ".add-to-cart .button.btn-cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".option-xs .swatch-label")
    private WebElementFacade product3Size;

    public void chooseProductColor() {
        clickOn(productColor);
    }
    public void chooseProduct1Size() {
        clickOn(product1Size);
    }
    public void chooseProduct3Size() {
        clickOn(product3Size);
    }
    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }



}

