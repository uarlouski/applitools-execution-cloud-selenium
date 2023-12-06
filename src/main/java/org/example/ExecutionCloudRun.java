package org.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.IosDeviceInfo;
import com.applitools.eyes.visualgrid.model.IosDeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ExecutionCloudRun {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        String server = System.getenv("EYES_SERVER_URL");
        caps.setCapability("applitools:eyesServerUrl", server);
        String apiKey = System.getenv("API_KEY");
        caps.setCapability("applitools:apiKey", apiKey);

        WebDriver driver = new RemoteWebDriver(new URL(Eyes.getExecutionCloudURL()), caps);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        try {
            executor.executeScript("applitools:startTest", Map.of(
                    "testName", "test-name",
                    "appName", "app-name"
            ));

            EyesRunner runner = new VisualGridRunner(5);
            Configuration configuration = new Configuration();
            configuration.addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_14));
            configuration.setServerUrl(server);
            configuration.setApiKey(apiKey);
            configuration.setAppName("My web app");
            configuration.setBatch(new BatchInfo("My batch name"));
            configuration.setTestName("My cool test");

            Eyes eyes = new Eyes(runner);
            eyes.setConfiguration(configuration);
            eyes.open(driver);

            driver.get(System.getenv("PAGE_URL"));

            eyes.check(Target.window());

            eyes.close(false);

            executor.executeScript("applitools:endTest" , Map.of(
                    "status", "Passed"
            ));
        } finally {
            driver.quit();
        }
    }
}
