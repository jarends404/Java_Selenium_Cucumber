package nl.example.configuration;

import nl.example.common.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHook {

    private final Browser browser = Browser.getInstance();

    @Before
    public void beforeScenario() {
        browser.startBrowser(BrowserType.CHROME);
    }

    @After
    public void afterScenario() {
        browser.quit();
    }

}
