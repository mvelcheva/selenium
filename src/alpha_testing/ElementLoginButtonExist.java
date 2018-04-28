package alpha_testing;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementLoginButtonExist {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://192.168.1.2:3000/login";
		driver.get(url);
		
		String tagClass = "btn";
		WebElement tagButton;
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
		String tagName = tagButton.getTagName();
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
		
		//test if button text is Login
		String tagInnerHTML = tagButton.getAttribute("innerHTML");
		if (tagInnerHTML.equals("Login")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}


}
