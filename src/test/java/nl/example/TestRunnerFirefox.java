package nl.example;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SuiteDisplayName("Cucumber Integration Tests - FIREFOX")
@IncludeEngines("cucumber")
@SelectClasspathResource("nl/example")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "nl.example")
@IncludeTags("firefox")
public class TestRunnerFirefox {
}
