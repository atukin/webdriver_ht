package bring_it_on.test;

import bring_it_on.page.PasteBinHome;
import bring_it_on.page.PasteBinPastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static bring_it_on.page.PasteBinHome.*;

public class PasteBinTest {

    private WebDriver driver;

    PasteBinPastePage pastePage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Create new paste with parameters")
    public void createNewPaste() {

        pastePage = new PasteBinHome(driver)
                .openPage()
                .createNewPasteWithParams(CODE, SYNTAX, EXPIRATION_TIME, PASTE_NAME);

        Assert.assertNotNull(pastePage, "The paste is not found");
    }

    @Test(description = "Validate paste title")
    public void validateTitle() {
        Assert.assertTrue(pastePage.getPasteTitle().contentEquals(PASTE_NAME), "Paste name doesn't match");
    }

    @Test(description = "Validate paste syntax")
    public void validateSyntax() {
        Assert.assertTrue(pastePage.getSyntaxName().contentEquals(SYNTAX), "Syntax is not Bash");
    }

    @Test(description = "Validate paste code")
    public void validateCode() {
        Assert.assertTrue(pastePage.getPasteData().contentEquals(CODE), "The code doesn't match");
    }

    @AfterTest(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}