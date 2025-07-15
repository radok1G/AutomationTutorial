package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{

    public ElementsPage(WebDriver driver){
        super(driver);

    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    // Fa clasa de Constants si apeleaza de acolo ca sa nu ai stringuri hardcodate
    public WebElement elementWebTables;

    public void interactWithWebTablesSubmenu(){
        elementHelper.clickJSElement(elementWebTables);
    }
}
