package ru.company.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[@class='alt-menu-mid__list']")
    WebElement menu;



    public void chooseMenuItem(String itemName) {
        WebElement element = menu.findElement(By.xpath("./descendant::*[contains(text(),'" + itemName + "')]"));
        scrllAndWaitToBeClickable(element);
        element.click();
    }

    public void chooseSubMenuItem(String itemName) {
        WebElement element = menu.findElement(By.xpath("/descendant::a[text()='" + itemName + "']"));
        scrllAndWaitToBeClickable(element);
        element.click();
    }
}
