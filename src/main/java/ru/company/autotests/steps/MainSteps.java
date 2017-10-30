package ru.company.autotests.steps;

import ru.company.autotests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MainSteps{

    MainPage page = new MainPage();

    @Step("выбран пункт меню - {0}")
    public void chooseMenuItem(String itemName) {
        String[] words = itemName.split(" ");
        page.chooseMenuItem(words[0]);
    }

    @Step("выбран подраздел - {0}")
    public void chooseSubmenuItem(String itemName) {
        page.chooseSubMenuItem(itemName);
    }

}
