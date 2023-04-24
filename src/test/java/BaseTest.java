import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
    public static ChromeOptions optionC;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    static void browserOptions() {

        optionC = new ChromeOptions();
        optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
    }

    @BeforeMethod
    static void setupBrowser() {
        driver = new ChromeDriver(optionC);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }

    //given

    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void logIn(String email,String password) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
}
    public void playASong(){
        WebElement playNext = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]"));
        playNext.click();
        playButton.click();
    }

    public boolean playingSong(){
        WebElement soundbars = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div"));
        return soundbars.isDisplayed();
    }
}
