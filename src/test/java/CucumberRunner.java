import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Иванка on 30.10.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.company.autotests.steps"}, plugin = {"ru.company.autotests.utils.MyAllureReporter",})
public class CucumberRunner {
}
