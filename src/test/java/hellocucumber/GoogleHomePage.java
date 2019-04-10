package hellocucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleHomePage extends BasePage {

    public SelenideElement pageTitleElement() {
        return $("title");
    }

    public SelenideElement searchTextBox() {
        return $(By.name("q"));
    }

    public SelenideElement searchButton() {
        return $(By.name("btnK"));
    }

    public ElementsCollection searchResultHeadings() {
        return $$("h3");
    }

}
