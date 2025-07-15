package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{

    public AlertFrameWindowPage (WebDriver driver){
    super(driver);
    }
    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertElements;

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElements;

    public void interactWithAlertsSubmenu(){
        elementHelper.clickJSElement(alertElements);
    }
    public void interactWithFramesSubMenu(){
        elementHelper.clickJSElement(framesElements);
    }

}
