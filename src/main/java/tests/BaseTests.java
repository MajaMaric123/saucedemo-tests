package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

@Getter
public class BaseTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;


    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("firefox") String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Maja\\Alas\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Maja\\Alas\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "D:\\Maja\\Alas\\edgedriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        this.loginPage = new LoginPage(driver, driverWait);
        this.inventoryPage = new InventoryPage(driver, driverWait);
        this.cartPage = new CartPage(driver, driverWait);
        this.checkoutPage = new CheckoutPage(driver, driverWait);
    }

    @AfterClass
    public void afterClass() {
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
