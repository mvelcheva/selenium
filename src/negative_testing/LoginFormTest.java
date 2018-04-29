package negative_testing;
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
//		driver.get(url);
		
		String[] usernames = new String[15];
		String[] passwords = new String[15];
		usernames[0] = "margarita1";
		passwords[0] = "simon";
		usernames[1] = "margarita";
		passwords[1] = "simon1";
		usernames[2] = "margarita1";
		passwords[2] = "simon1";
		usernames[3] = "margaritamargaritamargarita";
		passwords[3] = "simon";
		usernames[4] = "margarita";
		passwords[4] = "simonsimonsimonsimonsimon";
		usernames[5] = " margarita";
		passwords[5] = "simon";
		usernames[6] = "margarita ";
		passwords[6] = "simon";
		usernames[7] = " margarita ";
		passwords[7] = "simon";
		usernames[8] = "marg arita";
		passwords[8] = "simon";
		usernames[9] = " marg arita ";
		passwords[9] = "simon";
		usernames[10] = "margarita";
		passwords[10] = " simon";
		usernames[11] = "margarita";
		passwords[11] = "simon ";
		usernames[12] = "margarita";
		passwords[12] = "si mon";
		usernames[13] = "margarita";
		passwords[13] = " sim on ";
		usernames[14] = "margarita";
		passwords[14] = " simon ";
		if (usernames.length != passwords.length) {
			System.out.println("test fail!");
			return;
		}
		
		for(int i = 0; i < usernames.length; i++) {
			driver.get(url);
			System.out.println(i + ":" + usernames[i]);
			System.out.println(i + ":" + passwords[i]);
			String usernameId = "signin-username";
			WebElement tagUsername = driver.findElement(By.id(usernameId));
			tagUsername.sendKeys(usernames[i]);
			
			String passwordId = "signin-password";
			WebElement tagPassword = driver.findElement(By.id(passwordId));
			tagPassword.sendKeys(passwords[i]);
			
			String buttonClass = "btn";
			WebElement tagButton = driver.findElement(By.className(buttonClass));
			tagButton.click();
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			String tagXPath = "/html/body/div[1]/h1";
			WebElement tagHeading;
			try {
				tagHeading = driver.findElement(By.xpath(tagXPath));
			} catch (org.openqa.selenium.NoSuchElementException e) {
//				Assert.fail();
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
//				Assert.fail();
				System.out.println("test fail!");
			}
			
			//test if text is Unauthorized
			String tagInnerHTML = tagHeading.getAttribute("innerHTML");
			if (tagInnerHTML.equals("Unauthorized")) {
//				Assert.success();
				System.out.println("test success!");
			} else {
//				Assert.fail();
				System.out.println("test fail!");
				return;
			}
        }
		
	}

}
