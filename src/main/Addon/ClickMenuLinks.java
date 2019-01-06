package main.Addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

@Action(name="Click Menu Links")
public class ClickMenuLinks implements WebAction {

    public ArrayList<String> menuItems = new ArrayList<>();

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper) throws FailureException {
        // Get web driver instance
        WebDriver driver = webAddonHelper.getDriver();

        for (WebElement menu: driver.findElements(By.cssSelector(".navbar-fixed-top"))) {
            if (!menu.isDisplayed()) {
                continue;
            }

            for (WebElement element: menu.findElements(By.tagName("li"))) {
                menuItems.add(element.getText());
            }
            
            // Click all the heading
            for (String heading: menuItems) {
                driver.findElementByLinkText(heading).click();
            }
        }

        return ExecutionResult.PASSED;
    }
}
