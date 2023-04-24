import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
@Test
    public void playSong() throws InterruptedException {
 //given
    navigateToPage();
    logIn("Heavenmayhem@gmail.com","Everything2Me0628!");
//when
    playASong();
//then
    Assert.assertTrue(playingSong());
    }
}
