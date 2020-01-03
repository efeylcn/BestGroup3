package Pages.ServerPress.API.ServerPress.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
    this method will get hover over the webElement
    you need to pass the element and driver
     */
    public static void hover(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);

        actions.moveToElement(element).build().perform();
    }

    // drag and drop
      /*
      this method will take the text of the Webelement and retur the string
      you need pass the element
       */
    public static String getText(WebElement element){
        return element.getText();
    }

    /*
    this method will take list of webelements
    it will return list of text from the webelements
     */
    public static List<String > getElementsText(List<WebElement>elements){
        List <String > textList = new ArrayList<>();
        for(WebElement el: elements){
            if( !el.getText().isEmpty()){
                textList.add(el.getText());

            }
        }
        return textList;
    }
    public static void visisbilityOfElement(WebDriver driver, WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    //clickable, isAlertPresent
    public static void  switchWindow(String targetTitle, WebDriver driver){
        String origin = driver.getWindowHandle();
        Set<String > allWindows = driver.getWindowHandles();
        for (String windows:allWindows) {
            driver.switchTo().window(windows);
            if(driver.getTitle().equals(targetTitle)){
                return;
            }

        }
        driver.switchTo().window(origin);
    }




}
