package hellocucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleHomePage extends BasePage {

    public SelenideElement pageTitleElement = $("title");
    public SelenideElement searchTextBoxElement = $(byName("q"));
    public SelenideElement searchButtonElement = $(byName("btnK"));
    public ElementsCollection searchResultHeadings = $$(byCssSelector("h3"));
}
