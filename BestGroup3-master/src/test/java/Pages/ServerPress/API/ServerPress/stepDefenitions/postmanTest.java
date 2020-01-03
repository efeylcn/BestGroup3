package Pages.ServerPress.API.ServerPress.stepDefenitions;

import API.ServerPress.Utilities.Configuration;
import API.ServerPress.Utilities.Driver;
import API.ServerPress.pages.Pagepostman;
import API.ServerPress.pages.PostPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class postmanTest {
    Pagepostman pagepostman = new Pagepostman();
   PostPage postPage=new PostPage();
    Actions actions = new Actions(Driver.driver);


    WebDriverWait wait = new WebDriverWait(Driver.driver,5);

    @Given("^Navigate to your own web page$")
    public void navigate_to_your_own_web_page() throws Throwable {

        Driver.driver.get(Configuration.getProperties("postmanURL"));
       // Thread.sleep(3000);
        pagepostman.login.sendKeys("jan");
       // Thread.sleep(1000);
        pagepostman.password.sendKeys("askarov92");
        //Thread.sleep(1000);
        pagepostman.signInButton.click();

    }

    @Given("^Navigate to posts page$")
    public void navigate_to_posts_page() throws Throwable {
       postPage.addNEW.click();

    }

    @Then("^Create a post$")
    public void create_a_post() throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(postPage.addTitleField));
        postPage.addTitleField.sendKeys("New Post From Jan");
        wait.until(ExpectedConditions.visibilityOf(postPage.publishButton));
        postPage.publishButton.click();
        actions.moveToElement(postPage.publishButton).perform();
        actions.click().perform();
        actions.moveToElement(postPage.posts).perform();
        actions.click().perform();
        Driver.driver.switchTo().alert().accept();
        Assert.assertEquals(1,postPage.listOfPosts.size());

    }
}
