package org.example;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setCapability("applitools:eyesServerUrl", System.getenv("EYES_SERVER_URL"));
        caps.setCapability("applitools:apiKey", System.getenv("API_KEY"));

        WebDriver driver = new RemoteWebDriver(new URL(Eyes.getExecutionCloudURL()), caps);

        try {
            driver.get("https://example.com");

            // Exception in thread "main" org.openqa.selenium.WebDriverException: Request "openFunctionalSession" that was
            // sent to the address "[POST]https://jnjeyesapi.applitools.com/api/sessions/running?apiKey=Stbxs51wMxutCNZqtDq1gAJIkUfXmR97iYStb2kjQAHo110"
            // failed due to unexpected status Bad Request(400)
            ((JavascriptExecutor) driver).executeScript("applitools:startTest", "test-name", "app-name");

            String title = driver.getTitle();
            System.out.println("title " + title);
        } finally {
            driver.quit();
        }
    }
}
