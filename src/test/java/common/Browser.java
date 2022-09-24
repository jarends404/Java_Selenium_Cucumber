package common;

import configuration.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Browser {

    private static Browser browser;

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String GET_PAGE_READYSTATE = "return document.readyState";
    private static final String COMPLETE = "complete";

    public static Browser getInstance() {
        if (browser == null) {
            browser = new Browser();
        }
        return browser;
    }

    public void startBrowser(BrowserType browserType) {
        if (browserType.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equals(BrowserType.EDGE)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new UnsupportedOperationException("BrowserType: " + browserType.name() + " not supported.");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(String selector) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(GET_PAGE_READYSTATE).equals(COMPLETE));
        return driver.findElements(By.cssSelector(selector));
    }

    public WebElement findElement(String selector) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(GET_PAGE_READYSTATE).equals(COMPLETE));
        return driver.findElement(By.cssSelector(selector));
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }
}
