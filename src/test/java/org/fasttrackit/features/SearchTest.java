package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Steps
    private SearchSteps searchSteps;

    private String keyword = "necklace";
    private String productName = "SILVER DESERT NECKLACE";

    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Test
    public void searchProductTest() {
        searchSteps.navigateToHomePage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.verifySearchedProductInResults(productName);
    }
    @Test
    public void searchPricesTest() {
        searchSteps.navigateToHomePage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.sortByPrice();
        searchSteps.verifyPriceComparison();
    }
}
