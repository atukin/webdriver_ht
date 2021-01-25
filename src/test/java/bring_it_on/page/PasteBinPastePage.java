package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinPastePage extends AbstractPage {

    private String code;
    private String syntax;
    private String expirationTime;
    private String pasteName;

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement syntaxName;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement pasteData;

    public PasteBinPastePage(WebDriver driver, String code, String syntax, String expirationTime, String pasteName) {
        super(driver);
        this.code = code;
        this.syntax = syntax;
        this.expirationTime = expirationTime;
        this.pasteName = pasteName;
    }

    public String getPasteTitle() {
        System.out.println("Paste title is: " + pasteTitle.getText());
        return pasteTitle.getText();
    }

    public String getSyntaxName() {
        System.out.println("Syntax is: " + syntaxName.getText());
        return syntaxName.getText();
    }

    public String getPasteData() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//textarea[@class='textarea']")));
        System.out.println("Paste text: " + pasteData.getText());
        return pasteData.getText();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("RuntimeException");
    }
}