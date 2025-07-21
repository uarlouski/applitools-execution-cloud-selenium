package org.example;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.options.LayoutBreakpointsOptions;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.IosDeviceInfo;
import com.applitools.eyes.visualgrid.model.IosDeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MobileRun {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            EyesRunner runner = new VisualGridRunner(1);
            Configuration configuration = new Configuration();
            configuration.addBrowser(new IosDeviceInfo(IosDeviceName.iPad_Pro_11_inch_4));

            String server = System.getenv("EYES_SERVER_URL");
            String apiKey = System.getenv("API_KEY");
            configuration.setServerUrl(server);
            configuration.setApiKey(apiKey);
            configuration.setAppName("My web app");
            configuration.setBatch(new BatchInfo("My batch name mobile"));
            configuration.setTestName("My cool test mobile");

            configuration.setLayoutBreakpoints(true);
            LayoutBreakpointsOptions breakpointsOptions = configuration.getLayoutBreakpointsOptions();

            // Without reload broken page is loaded
            breakpointsOptions.reload(true);

            Eyes eyes = new Eyes(runner);
            eyes.setConfiguration(configuration);
            eyes.open(driver);

            driver.get(System.getenv("PAGE_URL"));
            handleOt(driver);

            // Reload breaks expanded accordion state
            expandAccordion(driver);

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File("screenshot.png"));

             eyes.check(Target.window());

            eyes.close(false);
        } finally {
            driver.quit();
        }
    }

    private static void handleOt(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement otBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-banner-sdk")));
        otBanner.findElement(By.id("onetrust-accept-btn-handler")).click();
        wait.until(ExpectedConditions.invisibilityOf(otBanner));
    }

    private static void expandAccordion(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("kakoikadakoristiti")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@data-sb-field-path=\"product.uses\"]")));
    }
}
