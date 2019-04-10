package hellocucumber.acceptancetests;

import com.codeborne.selenide.junit.TextReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        tags = "~@wip",
        monochrome = true)
public class RunCucumberTest {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);
}