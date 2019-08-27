package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ViewDetailsPage extends PageObject {

    @FindBy(css = "img[alt='Indigo']")
    private WebElementFacade product1Color;
    @FindBy(css = ".option-m .swatch-label")
    private WebElementFacade product1Size;
    @FindBy(css = ".add-to-cart .button.btn-cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = "img[alt='Silver']")
    private WebElementFacade product2Color;
    @FindBy(css = ".option-4 .swatch-label")
    private WebElementFacade product2Size;
    @FindBy(css = "img[alt='Charcoal']")
    private WebElementFacade product3Color;
    @FindBy(css = ".option-8 .swatch-label")
    private WebElementFacade product3Size;

    public void chooseProduct1Color() {
        clickOn(product1Color);
    }

    public void chooseProduct1Size() {
        clickOn(product1Size);
    }

    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }

    public void chooseProduct2Color() {
        clickOn(product2Color);
    }

    public void chooseProduct2Size() {
        clickOn(product2Size);
    }

    public void chooseProduct3Color() {
        clickOn(product3Color);
    }

    public void chooseProduct3Size() {
        clickOn(product3Size);
    }
}
