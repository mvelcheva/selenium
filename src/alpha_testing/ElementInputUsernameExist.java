package alpha_testing;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementInputUsernameExist {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://192.168.1.2:3000/login";
		driver.get(url);

		//test if element is of type input
		String tagId = "signin-username";
		WebElement tagUserName;
		try {
			tagUserName = driver.findElement(By.id(tagId));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		if (tagUserName == null) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		String tagName = tagUserName.getTagName();
		if (tagName.equals("input")) {
//					Assert.success();
			System.out.println("test success!");
		} else {
//					Assert.fail();
			System.out.println("test fail!");
		}
		
		//test if element initial value is an empty string
		String tagValue = tagUserName.getAttribute("value");
		if (tagValue.equals("")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if placeholder equals margarita
		String tagPlaceholder = tagUserName.getAttribute("placeholder");
		if (tagPlaceholder.equals("margarita")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if maxlength equals 20
		String tagMaxlength = tagUserName.getAttribute("maxlength");
		if (tagMaxlength.equals("20")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if name equals username
		String tagAttrName = tagUserName.getAttribute("name");
		if (tagAttrName.equals("username")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if type equals text
		String tagAttrType = tagUserName.getAttribute("type");
		if (tagAttrType.equals("text")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}

}
