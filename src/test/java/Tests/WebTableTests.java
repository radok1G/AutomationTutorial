package Tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTableTests extends SharedData {


    @Test
    public void TestMethod (){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubmenu();

        int tableSize = 3;

        String firstNameValue = "Rajesh";
        String lastNameValue = "Patel";
        String emailValue = "test@test.com";
        String ageValue = "53";
        String salaryValue = "3000";
        String departmentValue = "contabilitate";

        String editFirstNameValue = "Radu";
        String editLastNameValue = "Coroian";
        String editEmailValue = "radu.upw@gmail.com";
        String editAgeValue = "32";
        String editSalaryValue = "19647";
        String editDepartmentValue = "QA";

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.addNewEntry(tableSize, firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);
        webTablesPage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue, editSalaryValue, editDepartmentValue);
        webTablesPage.deleteNewEntry(tableSize);
    }
}