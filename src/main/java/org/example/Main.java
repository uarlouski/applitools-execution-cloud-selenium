package org.example;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setCapability("applitools:eyesServerUrl", System.getenv("EYES_SERVER_URL"));
        caps.setCapability("applitools:apiKey", System.getenv("API_KEY"));

        WebDriver driver = new RemoteWebDriver(new URL(Eyes.getExecutionCloudURL()), caps);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        try {
            executor.executeScript("applitools:startTest", Map.of(
                    "testName", "test-name",
                    "appName", "app-name"
            ));

            driver.get("https://example.com");

            String title = driver.getTitle();
            System.out.println("title " + title);

            Map<String,String> paramsEnd = new HashMap<>();

            executor.executeScript("applitools:endTest" , Map.of(
                    "status", "Passed"
            ));
        } finally {
            // Exception in thread "main" org.openqa.selenium.WebDriverException: Body cannot be empty when content-type
            // is set to 'application/json'
            driver.quit();
        }
    }
}
