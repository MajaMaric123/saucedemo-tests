package test5tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test5pages.CartPage;
import test5pages.CheckoutPage;
import test5pages.InventoryPage;
import test5pages.LoginPage;

import java.time.Duration;

public class BaseTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.navigate().to("https://www.saucedemo.com/");

        this.loginPage = new LoginPage(driver, driverWait);
        this.inventoryPage = new InventoryPage(driver, driverWait);
        this.cartPage = new CartPage(driver, driverWait);
        this.checkoutPage = new CheckoutPage(driver, driverWait);
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
}
