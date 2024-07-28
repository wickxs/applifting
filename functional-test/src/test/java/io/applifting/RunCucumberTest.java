package io.applifting;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "functional-test/src/test/resources/features",
        glue = { "io.applifting.steps", "io.applifting.reports"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest {
}
