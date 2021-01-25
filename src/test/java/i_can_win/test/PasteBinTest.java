package i_can_win.test;

import i_can_win.page.PasteBinHome;
import i_can_win.page.PasteBinPostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Create new paste with parameters")
    public void createNewPaste() {

        PasteBinPostPage pastePage = new PasteBinHome(driver)
                .openPage()
                .createNewPasteWithParams("Hello from WebDriver", "10 Minutes", "helloweb");

        Assert.assertNotNull(pastePage, "The paste is not found");
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
