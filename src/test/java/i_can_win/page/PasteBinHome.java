package i_can_win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PasteBinHome extends AbstractPage {

    private final static String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationContainer;

//    @FindBy(id = "select2-postform-expiration-result-ai0c-10M")
//    private WebElement expirationAfter10Minutes;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@class='btn -big'][@type='submit']")
    private WebElement createNewPasteButton;

    public PasteBinHome(WebDriver driver) {
        super(driver);
    }

    public PasteBinHome openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//button[@class='btn -big'][@type='submit']")));
        return this;
    }

    public PasteBinPostPage createNewPasteWithParams(String code, String expirationTime, String pasteName) {

        codeInput.sendKeys(code);
        expirationContainer.click();

        WebElement expirationAfter10Minutes = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//li[text()=\'" + expirationTime + "\']")));
        expirationAfter10Minutes.click();

        pasteNameInput.sendKeys(pasteName);
        createNewPasteButton.click();

        return new PasteBinPostPage(driver, code, expirationTime, pasteName);
    }


}
