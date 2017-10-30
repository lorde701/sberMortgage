package ru.company.autotests.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 30.10.2017.
 */
public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MortgageSteps mortgageSteps = new MortgageSteps();
    MortgageCalculatorSteps mortgageCalculatorSteps = new MortgageCalculatorSteps();

    @When("^в меню (.*) выбран пункт (.*)$")
    public void chooseMenuAndSubmenuItems(String menu, String submenu) {
        mainSteps.chooseMenuItem(menu);
        mainSteps.chooseSubmenuItem(submenu);
    }

    @When("^нажата кнопка (.*)$")
    public void clickButton(String buttonName) {
        mortgageSteps.clickOnButton(buttonName);
    }

    @When("^в разделе (.*) выбрать пункт (.*)$")
    public void chooseValue(String field, String value) {
        mortgageCalculatorSteps.setValue(field, value);
    }

    @When("^заполняются поля:$")
    public void fillDate(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> mortgageCalculatorSteps.fillField(field, value));
    }

//    @When("^чекбокс дополнительное условие \"(.*)\" отмчен$")
//    public void checkAdditionalCondition(String value) {
//        mortgageCalculatorSteps.checkAdditionalCondition(value);
//    }

//    @When("^чекбокс \"(.*)\" отмечен$")
//    public void checkAdditionPrivileges(String value) {
//        mortgageCalculatorSteps.checkAdditionalPrivileges(value);
//    }

    @When("^Ненужные чекбоксы убраны$")
    public void unchecked() {
        mortgageCalculatorSteps.checkAdditionalPrivileges(" Закажите услугу у вашего менеджера в кабинете клиента. ");
        mortgageCalculatorSteps.checkAdditionalPrivileges("счет страхования жизни и здоровья в страховой компании «Сбербанк страхование»");
    }

    @Then("проверка полученных значений")
    public void checkDate(DataTable data) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.asMap(String.class, String.class)
                .forEach((field, expectedValue)->mortgageCalculatorSteps.checkDate(expectedValue, field));
    }

//    @When("^проверка соответствия ожидаемого значения значения {0} реальному {1} из поля {2}")
//    public void check(String expectedValue, String field) {
//        mortgageCalculatorSteps.checkDate(expectedValue,field);
//    }
}
