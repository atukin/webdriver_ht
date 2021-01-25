package i_can_win.page;

import org.openqa.selenium.WebDriver;

public class PasteBinPostPage extends AbstractPage {

    private String code;
    private String expirationTime;
    private String pasteName;

    public PasteBinPostPage(WebDriver driver, String code, String expirationTime, String pasteName) {
        super(driver);
        this.code = code;
        this.expirationTime = expirationTime;
        this.pasteName = pasteName;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("");
    }
}