package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHome extends AbstractPage {

    private final static String HOMEPAGE_URL = "https://pastebin.com";
    public static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    public static final String SYNTAX = "Bash";
    public static final String EXPIRATION_TIME = "10 Minutes";
    public static final String PASTE_NAME = "how to gain dominance among developers";

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(id = "select2-postform-format-container")
    private WebElement formatContainer;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationContainer;

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

    public PasteBinPastePage createNewPasteWithParams(String code, String syntax, String expirationTime, String pasteName) {

        codeInput.sendKeys(code);
        formatContainer.click();

        WebElement bashSyntax = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//li[text()=\'" + syntax + "\']")));
        bashSyntax.click();

        expirationContainer.click();
        WebElement expirationAfter10Minutes = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//li[text()=\'" + expirationTime + "\']")));
        expirationAfter10Minutes.click();

        pasteNameInput.sendKeys(pasteName);
        createNewPasteButton.click();

        return new PasteBinPastePage(driver, code, syntax, expirationTime, pasteName);
    }
}