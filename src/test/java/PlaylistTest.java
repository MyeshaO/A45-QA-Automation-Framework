import Homework22.HomePage;
import Homework22.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistChangedName = "Oliver";
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginpage.logIn();
        homepage.doubleClickPlaylist();
        homepage.changePlaylistName(playlistChangedName);
        Assert.assertTrue(homepage.playlistExist(playlistChangedName));
    }
}
