package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;


    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
/**
    public ProfilePage(WebDriver driver) {
        driver.findElement(driver, this);
       // public void init(final WebDriver driver) {
            //this.driver = driver;
        this.driver = driver; }
*/
       /** public void init(final WebDriver driver) {
            this.driver = driver;
        }*/


    private WebElement userMenu;
    private WebElement logoutBtn1;


    public void PageObjectWithoutPageFactory(WebDriver driver){

        this.driver = driver;
       // String s = driver.getCurrentUrl();
       // driver.get(s);
        userMenu = driver.findElement(By.xpath("//*[contains(@class, 'user-account__name')]"));
       // this.driver = driver;


        //WebElement logoutBtn1;
        logoutBtn1 = driver.findElement(By.xpath("//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]"));
        userMenu.click();
        logoutBtn1 = driver.findElement(By.xpath("//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]"));

        logoutBtn1.click();

    }
 /** public void PageObjectWithoutPageFactory2(WebDriver driver){
  WebElement logoutBtn;
  logoutBtn = driver.findElement(By.xpath("//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]"));
 // logoutBtn = driver.findElement(By.xpath("//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]"));

  logoutBtn.click();
    }*/

    public String getUserName() {
        this.driver = driver;
        userMenu = driver.findElement(By.xpath("//*[contains(@class, 'user-account__name')]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__name')]")));
        String userName = userMenu.getText();
        return userName; }

}