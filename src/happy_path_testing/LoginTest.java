package happy_path_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	public String url;
	public WebDriver driver;

	public LoginTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		url = "http://192.168.1.2:3000/login";
	}
	
	@BeforeTest
	public void getBrowserPage() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void attemptToLogin() {
		String usernameId = "signin-username";
		WebElement tagUsername = driver.findElement(By.id(usernameId));
		tagUsername.clear();
		String tagUsernameName = tagUsername.getAttribute("name");
		Assert.assertEquals(tagUsernameName, "username");
		tagUsername.sendKeys("margarita");
		
		String passwordId = "signin-password";
		WebElement tagPassword = driver.findElement(By.id(passwordId));
		tagPassword.clear();

		String tagPasswordName = tagPassword.getAttribute("name");
		Assert.assertEquals(tagPasswordName, "password");
		tagPassword.sendKeys("simon");
		
		String buttonClass = "btn";
		WebElement tagButton = driver.findElement(By.className(buttonClass));
		tagButton.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String tagClass = "form-signin-heading";
		WebElement tagHeading = driver.findElement(By.className(tagClass));
		String tagInnerHTML = tagHeading.getAttribute("innerHTML");
		Assert.assertEquals(tagInnerHTML, "Welcome, Margarita");
	}
	
	@AfterSuite
	public void TearDown() {
		driver.close();
	}
}
