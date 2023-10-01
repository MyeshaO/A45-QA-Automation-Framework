import Homework22.HomePage;
import Homework22.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{
    @Test
     public void loginValidEmailPasswordTest() {


        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginpage.provideEmail("myesha.oliver@testpro.io").providePassword("Everything2Me0628!").setSubmitButton();
        Assert.assertTrue(homepage.getUserAvatar());
    }
}


