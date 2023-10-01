import Homework22.HomePage;
import Homework22.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework25 extends BaseTest{
    @Test
    public void loginValidEmailPasswordTest() {


        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());

        loginpage.provideEmail("myesha.oliver@testpro.io").providePassword("Everything2Me0628!").setSubmitButton();
        Assert.assertTrue(homepage.getUserAvatar());
    }
    @Test
    public void loginInvalidEmailPasswordTest(){
        LoginPage loginpage = new LoginPage(getDriver());

        loginpage.provideEmail("heavenmayhem@gmail.com").providePassword("Everything2Me0628!").setSubmitButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
}


}
