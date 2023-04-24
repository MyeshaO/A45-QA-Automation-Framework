import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test

    public void addSongToPlaylist() throws InterruptedException {
        String newSongAdded = "added 1 new song into";
//given
        navigateToPage();
        provideEmail("heavenmayhem@gmail.com");
        providePassword("Everything2Me0628!");
        clickSubmit();
//when
        searchSong("Ketsa - That_s a Beat");
        clickViewAll();
        selectSong();
        clickAddTo();
        choosePlaylist();
//then
        Assert.assertTrue(isDisplayedNotificationMessage());

    }

}

