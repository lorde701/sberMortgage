package ru.company.autotests.steps;

import org.junit.Assert;
import ru.company.autotests.pages.MortgageCalculatorPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MortgageCalculatorSteps {

    MortgageCalculatorPage page = new MortgageCalculatorPage();

    @Step("выбрать из раздела {0} значение {1}")
    public void setValue(String field, String value) {
        page.choose(field, value);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        page.inputField(field, value);
    }

    @Step("чекбокс {0} отмечен")
    public void checkAdditionalCondition(String value) {
        page.checkAdditionalCondition(value);
    }

    @Step("чекбокс \"{0}\" отмечен")
    public void checkAdditionalPrivileges(String value) {
        String[] words = value.split(" ");
        String newValue = words[words.length-3] + " " + words[words.length-2] + " " + words[words.length-1];
        page.checkAdditionalPrivileges(newValue);
    }

    @Step("проверка соответствия ожидаемого значения {0} и фактического в поле {1}")
    public void checkDate(String expectedValue, String field) {
        String temp = page.getFieldValue(field);
        temp = temp.substring(0, temp.length() - 2);
        temp = temp.replace(" ","");
        Assert.assertEquals(expectedValue, temp);
    }
}
