package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

    private WebDriver driver;
    private By rightClickBox = By.id("hot-spot");

    public ContextMenu(WebDriver driver){
        this.driver=driver;
    }

    public void rightClickOnBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClickBox)).perform();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

}
