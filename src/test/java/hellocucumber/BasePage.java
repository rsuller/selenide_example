package hellocucumber;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

    public void enterText(SelenideElement element, String textToEnter) {
        element.sendKeys(textToEnter);
    }

    public void clickButton(SelenideElement element) {
        element.click();
    }

    public void checkCollectionHasMoreThanOne(ElementsCollection elementsCollection) {
        elementsCollection.shouldHave(CollectionCondition.sizeGreaterThan(1));
    }

    public void checkPageTitle(SelenideElement element, String pageTitle) {
        element.shouldHave(Condition.text(pageTitle));
    }




}
