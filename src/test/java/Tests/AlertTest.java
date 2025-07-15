package Tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithAlertsSubmenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("alandala");

    }
}