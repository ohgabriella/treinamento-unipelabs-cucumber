package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@teste",
        features = "src/test/resources/features/alugarFilme.feature",
        glue = {"steps.alugarfilme"},
        snippets = CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true)
public class AluguelFilmeRunner {

}
