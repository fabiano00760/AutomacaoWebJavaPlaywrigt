package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,

        features = "src/main/java/Features/Login.feature",
        glue = {"stepes", "fabricaDeDriver"},
        tags = "@WEB",
        monochrome = true,
        publish = true,
        plugin = {"pretty", "json:target/report.json", "junit:target/report.xml", "html:target/cucumber-reports.html"},
        snippets = SnippetType.CAMELCASE,
        stepNotifications = true)


public class Runner {

}