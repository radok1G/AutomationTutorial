package Tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertFrameWindowMenu);

        WebElement browserWindowsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickJSElement(browserWindowsSubMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTabElement);

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(tabList.get(0));
        System.out.println(driver.getCurrentUrl());

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();
        System.out.println(driver.getCurrentUrl());

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());

        driver.quit();

    }
}