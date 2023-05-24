package Homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By choosePlaylist = By.cssSelector("#playlists > ul > li:nth-child(3)");
    By playlistName = By.cssSelector("[name='name']");

    public void doubleClickPlaylist() {
        doubleClick(choosePlaylist);
    }

    public void changePlaylistName(String playlistChangedName) {
        findElement(playlistName).sendKeys(playlistChangedName);
        findElement(playlistName).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistName).sendKeys(playlistChangedName);
        findElement(playlistName).sendKeys(Keys.ENTER);
    }

    public boolean playlistExist(String playlistChangedName) {
        By newPlaylist = By.xpath("//a[text()='" + playlistChangedName + "']");
        return findElement(newPlaylist).isDisplayed();
    }

    public boolean getUserAvatar() {
        By userAvatar = By.cssSelector("#userBadge > a.view-profile > img");
        return findElement(userAvatar).isDisplayed();
    }
}