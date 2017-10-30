package ru.company.autotests.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.company.autotests.steps.BaseSteps;

import java.util.Set;

/**
 * Created by Иванка on 30.10.2017.
 */
public class BasePage {
    WebDriver driver = BaseSteps.getDriver();

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void scrllAndWaitToBeClickable(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchToNewWindowOnClick(WebElement element, long timeOutInSec) {
        final Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        scrllAndWaitToBeClickable(element);
        element.click();
        String newWindowHandle = (new WebDriverWait(BaseSteps.getDriver(), timeOutInSec))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        BaseSteps.getDriver().switchTo().window(newWindowHandle);
    }

    public void fillField(WebElement element, String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE + text);
    }
}
