package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test

    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        // wait implicit linia cu duration.ofseconds

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement AlertFrame = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", AlertFrame);

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();


        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        alertOkButton.click();

        // wait explicit pentru alerta

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

//        try {
//            Thread.sleep(5000); //
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        alertOkCancelElement.click();

        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        alertPromptElement.click();

        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Fasole si Praslea");
        alertPrompt.accept();

        driver.quit();

    }
}