package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://fasttrackit.org/selenium-test/checkout/cart/")
public class CartPage extends PageObject {

    @FindBy(css=".data-table tbody tr .product-cart-total")
    private List<WebElementFacade> cartListOfProductsPrices;
    private int priceInt;
    private int sumOfPricesInt=0;

    @FindBy(css = "#shopping-cart-totals-table tbody tr:nth-child(1)  td:nth-child(2)  .price")
    private WebElementFacade productsPricesSubtotal;

    private int pricesSubtotalInt;

      public int getSumOfPricesInt() {
          for (WebElementFacade price : cartListOfProductsPrices)
              for (int i = 0; i < price.getText().length(); i++) {
                  if (price.getText().charAt(i) == ',') {
                      priceInt = Integer.valueOf(price.getText().substring(0, i - 1));
                  }
              }
          return sumOfPricesInt += priceInt;
      }
       public int getPricesSubtotalInt() {
           for (int i = 0; i < productsPricesSubtotal.getText().length(); i++) {
               if (productsPricesSubtotal.getText().charAt(i) == ',') {
                   pricesSubtotalInt = Integer.valueOf(productsPricesSubtotal.getText().substring(0, i - 1));
               }
           }
           return pricesSubtotalInt;
       }
       public boolean verifySumOfPrices(){
         if (sumOfPricesInt == pricesSubtotalInt) {
                 return true;
         } else return false;
     }
}



