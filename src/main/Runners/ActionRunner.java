package main.Runners;

import io.testproject.java.classes.DriverSettings;
import io.testproject.java.enums.DriverType;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import main.Addon.ClickMenuLinks;

public class ActionRunner {

    private final static String devToken = "kNfpUCmY_3Gg_reU2mfsBgRTAq3XizjJDpiQReY813E1";
    private final static String URL = "http://eaapp.somee.com/";

    public static void main(String[] args) throws Exception {

        DriverSettings driverSettings = new DriverSettings(DriverType.Chrome);

        try (Runner runner = new Runner(devToken, driverSettings)) {
            ClickMenuLinks clickMenuLinks = new ClickMenuLinks();

            WebDriver driver = runner.getDriver(clickMenuLinks);
            driver.navigate().to(URL);

            // Click all the menu links
            runner.run(clickMenuLinks);
        }
    }
}
