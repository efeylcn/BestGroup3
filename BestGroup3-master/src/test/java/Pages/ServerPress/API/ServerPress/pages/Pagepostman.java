package Pages.ServerPress.API.ServerPress.pages;

import API.ServerPress.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagepostman {

    WebDriver driver;

    public Pagepostman(){
        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement login;
    @FindBy(xpath = "//input[@id='user_pass']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='wp-submit']")
    public WebElement signInButton;



}
