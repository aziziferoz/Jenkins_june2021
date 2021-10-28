package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	String userName = "demo@techfios.com";
	String password = "abc123";

	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@class='btn btn-success block full-width']")
	WebElement SIGNIN_BUTTON_ELEMENT;

	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickSignInButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}

	public void testLoginPage(String userName, String password) {

		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}

}
