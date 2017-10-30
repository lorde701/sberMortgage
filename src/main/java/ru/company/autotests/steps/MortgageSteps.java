package ru.company.autotests.steps;

import ru.company.autotests.pages.MortgagePage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MortgageSteps {

    MortgagePage page = new MortgagePage();

    @Step("произошло надатие на кнопку {0}")
    public void clickOnButton(String buttonName) {
        page.clickButton(buttonName);
    }
}
