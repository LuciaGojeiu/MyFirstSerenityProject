package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void searchForKeyword(String keyword){
        homePage.setSearchField(keyword);
        homePage.clickSearchButton();
    }

    @Step
    public void verifySearchedProductInResults(String productName){
        Assert.assertTrue("Product not in the list.",searchResultsPage.isProductOnPage(productName));
    }

    @Step
    public void sortByPrice(){
        searchResultsPage.sortProductsByPrice();
    }

    @Step
    public void verifyPriceComparison(){
        Assert.assertTrue("Price are not ordered in ascending order",searchResultsPage.pricesComparison());
    }
}
