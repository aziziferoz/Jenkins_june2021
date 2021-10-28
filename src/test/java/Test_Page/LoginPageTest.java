package Test_Page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import util1.BrowserFactory;

public class LoginPageTest extends BrowserFactory {
	LoginPage loginPageObj;

	@BeforeMethod
	public void setUp() {
		initDriver();
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test
	public void loginTest() throws Throwable {
		loginPageObj.insertUserName("demo@techfios.com");
		loginPageObj.insertPassword("abc123");
		loginPageObj.clickSignInButton();
		takeScreenShot(driver);
	}

	@Test
	public void pageTitleTest() throws Throwable {
		loginPageObj.insertUserName("demo@techfios.com");
		loginPageObj.insertPassword("abc123");
		loginPageObj.clickSignInButton();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPageObj.verifyDashboardPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		takeScreenShot(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
