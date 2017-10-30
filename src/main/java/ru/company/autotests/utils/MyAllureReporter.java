package ru.company.autotests.utils;

import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.company.autotests.steps.BaseSteps;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;

/**
 * Created by Иванка on 30.10.2017.
 */
public class MyAllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) takeScreenshot(result);
        super.result(result);
    }



    public void takeScreenshot(Result step) {
        if (BaseSteps.getDriver() != null) {
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent(((TakesScreenshot)BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES),
                    "Скриншот в момент ошибки", "image/png"));
        }
    }
}
