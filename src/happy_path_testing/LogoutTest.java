package happy_path_testing;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest {

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
		
		//test if elements not found
		try {
			tagUsername = driver.findElement(By.id(usernameId));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.success();
			System.out.println("test success username not found!");
		}
		
		try {
			tagPassword = driver.findElement(By.id(passwordId));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.success();
			System.out.println("test success password not found!");
		}
		try {
			String tagXpath = "//*[@id=\"form-signin\"]/p[3]/button";
			tagButton = driver.findElement(By.xpath(tagXpath));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.success();
			System.out.println("test success login not found!");
		}
		
		tagClass = "btn";
		try {
			tagButton = driver.findElement(By.className(tagClass));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		if (tagButton == null) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if element is of type button
		tagName = tagButton.getTagName();
		if (tagName.equals("button")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
		}
		
		//test if type of button is submit
		String tagAttrType = tagButton.getAttribute("type");
		if (tagAttrType.equals("submit")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if button text is Logout
		tagInnerHTML = tagButton.getAttribute("innerHTML");
		if (tagInnerHTML.equals("Logout")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
//		Set<Cookie> cookies = driver.manage().getCookies();
		String tagXpath = "//*[@id=\"form-signin\"]/p/button";
		tagButton = driver.findElement(By.xpath(tagXpath));
		tagButton.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		url = "http://192.168.1.2:3000/welcome";
		driver.get(url);
		
		//test if text is Unauthorized
		tagClass = "form-signin-heading";
		tagHeading = driver.findElement(By.xpath("/html/body/h1"));
		tagInnerHTML = tagHeading.getAttribute("innerHTML");
		System.out.println(tagInnerHTML);
		if (tagInnerHTML.equals("Unauthorized")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}
		
}
	
