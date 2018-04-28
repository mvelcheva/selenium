package happy_path_testing;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://192.168.1.2:3000/login";
		driver.get(url);
		
		String usernameId = "signin-username";
		WebElement tagUsername = driver.findElement(By.id(usernameId));
		tagUsername.sendKeys("margarita");
		
		String passwordId = "signin-password";
		WebElement tagPassword = driver.findElement(By.id(passwordId));
		tagPassword.sendKeys("simon");
		
		String buttonClass = "btn";
		WebElement tagButton = driver.findElement(By.className(buttonClass));
		tagButton.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("sdfdsf");
		
		String tagClass = "form-signin-heading";
		WebElement tagHeading;
		try {
			tagHeading = driver.findElement(By.className(tagClass));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		if (tagHeading == null) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if element is of type h1
		String tagName = tagHeading.getTagName();
		if (tagName.equals("h1")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
		}
		
		//test if text is Welcome, Margarita
		String tagInnerHTML = tagHeading.getAttribute("innerHTML");
		if (tagInnerHTML.equals("Welcome, Margarita")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}

}
