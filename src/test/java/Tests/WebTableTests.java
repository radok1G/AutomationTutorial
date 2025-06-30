package Tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTableTests extends SharedData {


    @Test
    public void TestMethod (){

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickJSElement(elementsMenu);

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickJSElement(webTablesSubMenu);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: " + tableSize + " is not correct");

        //Identificare de element.
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickJSElement(addElement);

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Rajesh";
        elementHelper.fillElement(firstnameElement, firstnameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "Patel";
        elementHelper.fillElement(lastnameElement, lastnameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "53";
        elementHelper.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "3000";
        elementHelper.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "contabilitate";
        elementHelper.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //Editare de functionlitate
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        WebElement editFirstNameEelement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Nyan";
        editFirstNameEelement.clear();
        elementHelper.fillElement(editFirstNameEelement, editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Cat";
        editLastNameElement.clear();
        elementHelper.fillElement(editLastNameElement, editLastNameValue);

        WebElement editEmailEelement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "testemail@testest.com";
        editEmailEelement.clear();
        elementHelper.fillElement(editEmailEelement, editEmailValue);

        WebElement editAgeEelement = driver.findElement(By.id("age"));
        String editAgeValue = "11";
        editAgeEelement.clear();
        elementHelper.fillElement(editAgeEelement, editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "40";
        editSalaryElement.clear();
        elementHelper.fillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Finante";
        editDepartmentElement.clear();
        elementHelper.fillElement(editDepartmentElement, editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickElement(editLine);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));

        //Delete element
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);

    }
}