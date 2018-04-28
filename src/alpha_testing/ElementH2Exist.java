package alpha_testing;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementH2Exist {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://192.168.1.2:3000/login";
		driver.get(url);
		
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
		
		//test if element is of type h2
		String tagName = tagHeading.getTagName();
		if (tagName.equals("h2")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
		}
		
		//test if text is Please login
		String tagInnerHTML = tagHeading.getAttribute("innerHTML");
		if (tagInnerHTML.equals("Please login")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}

}
