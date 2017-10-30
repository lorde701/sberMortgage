package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.company.autotests.steps.BaseSteps;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MortgageCalculatorPage extends BasePage {

    @FindBy(xpath = "//div[@class='card___5T3k mainArea___1vwy']")
    WebElement forma;

    @FindBy(xpath = "//div[@id='productPopover']")
    WebElement options;

    @FindBy(xpath = "//div[@class='mainAreaSwitches___2ugw']")
    WebElement additionalConditions;

    @FindBy(xpath = "//div[@class='wrapper___2BYL ']")
    WebElement additionalPrivileges;

    @FindBy(xpath = "//div[@class='wrapper___2BYL rightColumnResults___NqA5']")
    WebElement rightSection;

    private String xpathToInput= "./descendant::*[text()='%s']/ancestor::div[@class='inputRowTitle___1IE3']/following-sibling::div/descendant::div[@class='wrapper___3-Vr']/descendant::input";


    public void choose(String fieldName, String value) {
        WebElement element = forma.findElement(By.xpath("./descendant::div[text()='" + fieldName + "']/parent::div/following-sibling::div"));
        //scrllAndWaitToBeClickable(element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        element = options.findElement(By.xpath("./div[text()='" + value + "']"));
        scrllAndWaitToBeClickable(element);
        element.click();
    }

    public void inputField(String fieldName, String value) {
        WebElement element = forma.findElement(By.xpath(String.format(xpathToInput, fieldName)));
        element.click();
        fillField(element, value);
        element.click();
    }

    public void checkAdditionalCondition(String value) {
        WebElement element = additionalConditions.findElement(By.xpath("./descendant::span[text()='" + value + "']/ancestor::div[@class='wrapper___1I6P switchRow___1g9g']/descendant::label[@class='checkboxWrap___2QG4']"));
        scrllAndWaitToBeClickable(element);
        element.click();
    }

    public void checkAdditionalPrivileges(String value /*часть предложения*/) {
        WebElement element = additionalPrivileges.findElement(By.xpath("./descendant::span[contains(text(),'" + value + "')]/ancestor::div[@class='wrapper___1I6P ']/descendant::label[@class='checkboxWrap___2QG4']"));
        scrllAndWaitToBeClickable(element);
        element.click();
    }

    public String getFieldValue(String fieldName) {
        return rightSection.findElement(By.xpath("./descendant::span[text()='" + fieldName + "']/following-sibling::div/span")).getText();
    }

}
