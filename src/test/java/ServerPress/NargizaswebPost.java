package ServerPress;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

public class NargizaswebPost {

    NargizasPostPages narPage=new NargizasPostPages();
    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
    Actions act =new Actions(Driver.driver);

    public NargizaswebPost() throws InterruptedException {
    }

    @Given("^navigate to nargiza's web page$")
    public void navigate_to_nargiza_s_web_page() throws Throwable {
        Driver.driverSetup("Chrome");
        Driver.driver.get(Configuration.getProperties("nargiza"));
    }
    @Then("^navigate to the post's page$")
    public void navigate_to_the_post_s_page() throws Throwable {
        narPage.userNmae.sendKeys("admin");
        narPage.passWord.sendKeys("admin");
        narPage.logIn.click();
    }
    @Then("^create post$")
    public void create_post() throws Throwable {
        narPage.post.click();
        narPage.addNew.click();
        narPage.title.sendKeys("My second Post");
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", narPage.publish);
        Thread.sleep(2000);
        narPage.publish2.click();
    }
    @Then("^go to posts and delete one post and verify it has been deleted$")
    public void goToPostsAndDeleteOnePostAndVerifyItHasBeenDeleted() throws Throwable {
        narPage.post.click();
        int beforeDelete=narPage.numberOfPost.size();
        BrowserUtils.hover(narPage.postToDelete, Driver.driver);
        narPage.postToTrash.click();
        int afterDelete= narPage.numberOfPost.size();
        Assert.assertNotSame(beforeDelete,afterDelete);
    }
    @Then("^go to posts and update one of the posts and very it \"([^\"]*)\"$")
    public void goToPostsAndUpdateOneOfThePostsAndVeryIt(String expectedUpdate) throws Throwable {
        narPage.post.click();
        act.moveToElement(narPage.postToUpdate).build().perform();
        Thread.sleep(2000);
        narPage.postEdit.click();
        narPage.updateField.clear();
        narPage.updateField.sendKeys("My second update was just a Miracle");
        narPage.updateButton.click();
        String actualConfirm =narPage.updatedVerification.getText();
        String expectedConfirm=expectedUpdate;
        Thread.sleep(1000);
        Assert.assertTrue(actualConfirm.contains(expectedConfirm));
    }


}
