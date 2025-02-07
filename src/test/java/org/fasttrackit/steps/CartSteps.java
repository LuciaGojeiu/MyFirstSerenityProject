package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.ViewDetailsPage;
import org.junit.Assert;

public class CartSteps {

    private ViewDetailsPage viewDetailsPage;
    private CartPage cartPage;

    @Step
    public void addToCartProduct1() {
        viewDetailsPage.chooseProductColor();
        viewDetailsPage.chooseProduct1Size();
        viewDetailsPage.clickAddToCartButton();
    }

    @Step
    public void addToCartProduct2() {
        viewDetailsPage.clickAddToCartButton();
    }

    @Step
    public void addToCartProduct3() {
        viewDetailsPage.chooseProductColor();
        viewDetailsPage.chooseProduct3Size();
        viewDetailsPage.clickAddToCartButton();
    }

    @Step
    public void verifyProductsPricesTotal() {
        Assert.assertTrue(" The sum of prices is not correctly calculated", cartPage.verifySumOfPrices());
    }
}
