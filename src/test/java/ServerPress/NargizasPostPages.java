package ServerPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class NargizasPostPages {

    WebDriver driver;
    public NargizasPostPages() throws InterruptedException {
        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[1]") //*[@id="menu-posts"]/a/div[3]
    public WebElement post;
    @FindBy(xpath =  "//*[@id=\"wp-admin-bar-site-name\"]")
    public  WebElement website;
    @FindBy (xpath = "//input[@id='user_login']")
    public  WebElement userNmae;
    @FindBy (xpath = "//input[@id='user_pass']")
    public  WebElement passWord;
    @FindBy (xpath = "//input[@id='wp-submit']")
    public  WebElement logIn;
    @FindBy (xpath = "//*[@id=\"wpbody-content\"]/div[3]/a")
    public  WebElement addNew;
    @FindBy (xpath = "//*[@id=\"post-title-0\"]")
    public  WebElement title;
    @FindBy (xpath= "//button[@class='components-button editor-post-publish-panel__toggle is-button is-primary']")
    public  WebElement publish;
    @FindBy (xpath= "//button[@class='components-button editor-post-publish-button is-button is-primary']")
    public  WebElement publish2;
    @FindBy(xpath = "//*[@id=\"post-97\"]/td[1]")
    public  WebElement postToDelete;
    @FindBy(xpath = "(//a[@class='submitdelete'])[1]")
    public  WebElement postToTrash;
    @FindBy(xpath = "//tbody[@id='the-list']/tr")
    public List<WebElement> numberOfPost;
    @FindBy(xpath = "//*[@id=\"post-29\"]/td[1]")
    public WebElement postToUpdate;
    @FindBy(xpath = "(//span[@class='edit']/a)[3]")
    public WebElement postEdit;
    @FindBy(xpath = "//p[@role='textbox']")
    public WebElement updateField;
    @FindBy(xpath = "//div//button[@class='components-button editor-post-publish-button is-button is-primary']")
    public WebElement updateButton;
    @FindBy(xpath = "//div[@class='components-snackbar__content']")//div[@class='components-snackbar']/div/text()
    public WebElement updatedVerification;
    @FindBy(xpath = "//tbody[@id='the-list']/tr/td/strong")
    public  List<WebElement> listofTitles;
    @FindBy(xpath = "(//strong/a[@class='row-title'])[1]")
    public  WebElement title1;
    @FindBy(xpath = "(//strong/a[@class='row-title'])[2]")
    public  WebElement title2;
}
