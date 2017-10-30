package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MortgagePage extends BasePage {

    @FindBy(xpath = "//div[@class='sbrf-div-list-wrapper bp-container bp-ui-dragRoot row with_gutter']")
    WebElement requestSection;

    public void clickButton(String buttonName) {
        WebElement element = requestSection.findElement(By.xpath("./descendant::*[text()='" + buttonName + "']"));
        switchToNewWindowOnClick(element, 5);
    }
}
