package Tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        elementHelper.validateListSize(tableList,tableSize);

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
        elementHelper.validateListSize(tableList, tableSize+1);
        elementHelper.validateElementContainsText(tableList.get(tableSize),firstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);

        //Editare de functionlitate
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Nyan";
        elementHelper.clearFillElement(editFirstNameElement, editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Cat";
        elementHelper.clearFillElement(editLastNameElement, editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "testemail@testest.com";
        elementHelper.clearFillElement(editEmailElement, editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "11";
        elementHelper.clearFillElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "40";
        elementHelper.clearFillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Finante";
        elementHelper.clearFillElement(editDepartmentElement, editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickElement(editLine);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

        //Delete element
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);
    }
}