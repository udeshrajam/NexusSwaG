package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/assessment.feature", glue = {"steps"},
        monochrome = true,
        dryRun = true,
        plugin = {"pretty", "junit:target/JUnitReports.xml", "json:target/JSONReports", "html:target/Reports/HTMLReports.html"}

)
public class TestRunner {
}
