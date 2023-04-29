import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    String deletemsg = "Deleted playlist";

    @Test
    public void deleteAPlaylist() throws InterruptedException {
        logIn("heavenmayhem@gmail.com", "Everything2Me0628!");
        choosePlaylist();
        deleteButton();
       // Assert.assertTrue(confirmDelete().contains(deletemsg));
    }


}
