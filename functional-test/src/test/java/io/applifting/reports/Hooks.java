package io.applifting.reports;

import io.applifting.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportListener.setDriver(WebDriverFactory.getDriver());
        ExtentReportListener.setUp(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentReportListener.tearDown(scenario);
//        WebDriverFactory.quitDriver();
    }
}
