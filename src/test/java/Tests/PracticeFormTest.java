package Tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickJSElement(formsMenu);

        WebElement practiceFormsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickJSElement(practiceFormsSubMenu);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Rajesha";
        elementHelper.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Rashada";
        elementHelper.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "test@test.com";
        elementHelper.fillElement(emailElement, emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0744122133";
        elementHelper.fillElement(mobileElement, mobileValue);

        WebElement subjectsEelement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Maths", "Arts", "Accounting", "Social Studies");
        for(int index=0; index<subjectsValue.size(); index++){
            elementHelper.fillElement(subjectsEelement, subjectsValue.get(index));
            elementHelper.pressElement(subjectsEelement, Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Sports", "Reading");
        for(int index=0; index<hobbiesElementList.size(); index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "/Users/raducoroian/IdeaProjects/AutomationTutorial/src/test/resources/Screenshot 2024-08-01 at 09.55.16.png";
        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());

        WebElement currentAdressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "str. Horea, nr.49";
        elementHelper.fillElement(currentAdressElement, currentAddressValue);

        WebElement stateElement = driver.findElement(By.id("stateCity-wrapper"));
        elementHelper.clickJSElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        elementHelper.fillElement(stateInputElement,stateValue);
        elementHelper.pressElement(stateInputElement, Keys.ENTER);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        elementHelper.fillElement(cityInputElement, cityValue);
        elementHelper.pressElement(cityInputElement, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue), "First Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not displayed right in the table");

    }
}
