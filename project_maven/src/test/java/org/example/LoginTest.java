package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    /**
     * осуществляем первоначальную настройку
     */
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    @BeforeClass

    public static void setup() {

        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("firefoxdriver"));
        //создание экземпляра драйвера
        driver=new FirefoxDriver();
        loginPage = new LoginPage(driver);
        profilePage=new ProfilePage(driver);
        //окно разварачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        //значение login/password берутся из файла настроек по аналогии с firefoxdriver
//и loginpage
//вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }
    @AfterClass
    public static void tearDown() {
      //  profilePage.entryMenu();
        //profilePage.userLogout();

        profilePage.PageObjectWithoutPageFactory(driver);

     //   driver.get("https://passport.yandex.ru/auth/welcome?retpath=https%3A%2F%2Fpassport.yandex.ru%2Fprofile&noreturn=1");
        driver.quit(); }
}

