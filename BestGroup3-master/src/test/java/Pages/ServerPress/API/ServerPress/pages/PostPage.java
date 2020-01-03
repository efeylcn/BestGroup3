package Pages.ServerPress.API.ServerPress.pages;

import API.ServerPress.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostPage {

    WebDriver driver;

    public PostPage(){

        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[.='Posts']")
    public WebElement posts;

    @FindBy(xpath="(//a[@href='https://www.jan.dev.cc/wp-admin/post-new.php'])[3]")
    public WebElement addNEW;

    @FindBy(id="post-title-0")//*[@id="post-title-0"]
    public WebElement addTitleField;

    @FindBy(xpath="(//button[@aria-disabled='false'])[2]")
    public WebElement publishButton;

    @FindBy(xpath="//a[@class='submitdelete']")
    public WebElement deleteFirstPostButton;

    @FindBy(xpath="//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr")
    public List<WebElement> listOfPosts;


    @FindBy(xpath="//a[@class='row-title']")
    public List<WebElement> listOfPostTitles;

    @FindBy(xpath="//button[@class='button-link editinline']")
    public List<WebElement> listOfQuickEditButton;

    @FindBy(xpath="//button[@class='button button-primary save alignright']")
    public WebElement updateButton;

    @FindBy(xpath="//input[@name='post_title']")
    public WebElement updateTitleField;

}
