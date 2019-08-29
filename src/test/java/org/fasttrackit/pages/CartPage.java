package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/checkout/cart/")
public class CartPage extends PageObject {

    @FindBy(css = ".first.odd .product-cart-total .cart-price .price")
    private WebElementFacade product1Price;
    @FindBy(css = ".even .product-cart-total .cart-price .price")
    private WebElementFacade product2Price;
    @FindBy(css = ".last.odd .product-cart-total .cart-price .price")
    private WebElementFacade product3Price;

    private int product1PriceInt;
    private int product2PriceInt;
    private int product3PriceInt;
    private int sumOfPricesInt;
    @FindBy(css = "#shopping-cart-totals-table tbody tr:nth-child(1)  td:nth-child(2)  .price")
    private WebElementFacade productsPricesSubtotal;
    private int pricesSubtotalInt;

    public int sumProductsPrices() {
        for (int i = 0; i < product1Price.getText().length(); i++) {
            if (product1Price.getText().charAt(i) == ',') {
                product1PriceInt = Integer.valueOf(product1Price.getText().substring(0, i - 1));
            }
        }
        for (int i = 0; i < product2Price.getText().length(); i++) {
            if (product2Price.getText().charAt(i) == ',') {
                product2PriceInt = Integer.valueOf(product2Price.getText().substring(0, i - 1));
            }
        }
        for (int i = 0; i < product3Price.getText().length(); i++) {
            if (product3Price.getText().charAt(i) == ',') {
                product3PriceInt = Integer.valueOf(product3Price.getText().substring(0, i - 1));
            }
        }
        return sumOfPricesInt = product1PriceInt + product2PriceInt + product3PriceInt;
    }

    public int pricesSubtotal() {
        for (int i = 0; i < productsPricesSubtotal.getText().length(); i++) {
            if (productsPricesSubtotal.getText().charAt(i) == ',') {
                pricesSubtotalInt = Integer.valueOf(productsPricesSubtotal.getText().substring(0, i - 1));
            }
        }
        return pricesSubtotalInt;
    }

    public boolean verifySumOfPrices() {
        if(sumOfPricesInt == pricesSubtotalInt){
            return true;
        }else return false;
    }
}
