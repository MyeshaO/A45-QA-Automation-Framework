import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
   public static WebDriver driver = null;
    public static ChromeOptions optionC;
    static String url = null;
    static WebDriverWait wait;
    static Actions actions;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})


    static void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        baseURL="https://bbb.testpro.io/";
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        url = baseURL;
        getDriver().get(url);


//        optionC = new ChromeOptions();
//        optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
//        driver = new ChromeDriver(optionC);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().minimize();
//        driver.get(baseURL);
    }

    private static WebDriver pickBrowser(String browser) {
        return null;
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

   @AfterMethod
   public static void tearDownBrowser() {
        threadDriver.get().close();
    threadDriver.remove();
   }

    public static void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }

    public static void searchSong(String songTitle){
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']"))).sendKeys(songTitle);
        //searchBar.sendKeys(songTitle);
    }

    public static void clickViewAll(){
        WebElement searchResults = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']"))).click();
    }

    public static void selectSong(){
        WebElement chooseSong = driver.findElement(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"))).click();
    }

    public static void clickAddTo(){
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to"))).click();
    }

    public static void choosePlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"))).click();
    }

    public static void deleteButton() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist"))).click();
        // deletePlaylist.click();
    }
    public static void choosePlaylistToDelete() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href = '#!/playlist/54189']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '#!/playlist/54189']"))).click();
        //playlistToDelete.click();
    }

    public static void getUserAvatar(){
        WebElement userAvatar = driver.findElement(By.cssSelector("#userBadge > a.view-profile > img"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.view-profile > img")));
    }


    public String confirmDelete() {
        WebElement deleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return deleteConfirmation.getText();
    }
}
