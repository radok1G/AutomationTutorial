package Tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.awt.*;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertFrameWindowMenu);

        WebElement framesELement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.clickJSElement(framesELement);

        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));

        elementHelper.printTextElement(firstBlockElement);

        frameHelper.switchToParent();

        frameHelper.switchFrameByString("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(secondBlockElement);



    }
}