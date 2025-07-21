package org.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Run {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            EyesRunner runner = new VisualGridRunner(1);
            Configuration configuration = new Configuration();
            RectangleSize viewportSize = new RectangleSize(1920, 1080);
            DesktopBrowserInfo info = new DesktopBrowserInfo(viewportSize, BrowserType.CHROME);
            configuration.addBrowser(info);

            String server = System.getenv("EYES_SERVER_URL");
            String apiKey = System.getenv("API_KEY");
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
        } finally {
            driver.quit();
        }
    }
}
