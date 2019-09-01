package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("https://fasttrackit.org/selenium-test/catalogsearch/result/")
public class SearchResultsPage extends PageObject {

    @FindBy(css = ".products-grid .item")
    private List<WebElementFacade> listOfProducts;
    @FindBy(css = ".category-products >.toolbar > .sorter > div select")
    private WebElementFacade sortByDrpList;
    @FindBy(css = ".category-products .item:first-child .price")
    private WebElementFacade firstProductPrice;
    @FindBy(css = ".category-products .item:last-child .price")
    private WebElementFacade lastProductPrice;

    @FindBy(css = ".item:first-child a[title='View Details']")
    private WebElementFacade viewDetailsButton;

    private String firstProdPrice;
    private String lastProdPrice;

    public boolean isProductOnPage(String productName) {
        for (WebElementFacade element : listOfProducts) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equals(productName))
                return true;
        }
        return false;
    }

    public void sortProductsByPrice() {
        clickOn(sortByDrpList);
        Select drpSortProductsBy = new Select(sortByDrpList);
        drpSortProductsBy.selectByVisibleText("Price");
    }

    public boolean pricesComparison() {
        for (int i = 0; i < firstProductPrice.getText().length(); i++) {
            if (firstProductPrice.getText().charAt(i) == ',') {
                firstProdPrice = firstProductPrice.getText().substring(0, i - 1);
            }
        }
        for (int i = 0; i < lastProductPrice.getText().length(); i++) {
            if (lastProductPrice.getText().charAt(i) == ',') {
                lastProdPrice = lastProductPrice.getText().substring(0, i - 1);
            }
        }
        return Integer.valueOf(firstProdPrice) < Integer.valueOf(lastProdPrice);
    }

    public void clickViewDetailsButton() {
        clickOn(viewDetailsButton);
    }
}



