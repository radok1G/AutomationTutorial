package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class WebTableTests {
    public WebDriver driver;

    //JavascriptExecutor executor = (JavascriptExecutor) driver;
    //executor.executeScript("arguments[0].click();", element);
    //cod pt click sub adds

    @Test

    public void testMethod(){
        //deschidem o instanta de Chrome

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elementsMenu);

        List<WebElement> tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even'or @class='rt-tr -odd']"));
        int tableSize = 2;
        Assert.assertEquals(tableList.size(), tableSize);

        // asertuequalsu ii subliniat ca se incarca siteul prea repede, si trebuie wait explicit

        //adu aminte sa ii spun la alex despre Waituri

        //depistezi un element

        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Fanela";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Trotila";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="radu@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="45";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="2500";
        salaryElement.sendKeys(salaryValue);

        WebElement departamentElement=driver.findElement(By.id("department"));
        String departamentValue="financiar";
        departamentElement.sendKeys(departamentValue);

       // JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement addLine=driver.findElement(By.id("submit"));
       // executor.executeScript("arguments[0].click();", addLine);

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even'or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize+1 );
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departamentValue));

        // edit functionality

        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Creanga";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLasttNameElement=driver.findElement(By.id("lastName"));
        String editLasttNameValue="Decopac";
        editLasttNameElement.clear();
        editLasttNameElement.sendKeys(editLasttNameValue);

        WebElement editemailElement=driver.findElement(By.id("userEmail"));
        String editemailValue="radubradu@gmail.com";
        editemailElement.clear();
        editemailElement.sendKeys(editemailValue);

        WebElement editageElement=driver.findElement(By.id("age"));
        String editageValue="342";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryElement=driver.findElement(By.id("salary"));
        String editsalarylValue="25252525";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalarylValue);

        WebElement editdepartamentElement=driver.findElement(By.id("department"));
        String editdepartmentValue="finante";
        editdepartamentElement.clear();
        editdepartamentElement.sendKeys(editdepartmentValue);

        WebElement editLine=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editLine);

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even'or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize+1 );
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLasttNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editemailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editsalarylValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editdepartmentValue));

        //stergem un element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even'or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);

    }
}
