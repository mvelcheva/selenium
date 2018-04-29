package alpha_testing;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementInputPasswordExist {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Margarita\\Desktop\\eclipse-java-oxygen-2-win32\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "http://192.168.1.2:3000/login";
		driver.get(url);

		//test if element is of type input
		String tagId = "signin-password";
		WebElement tagPassword;
		try {
			tagPassword = driver.findElement(By.id(tagId));
		} catch (org.openqa.selenium.NoSuchElementException e) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		if (tagPassword == null) {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		String tagName = tagPassword.getTagName();
		if (tagName.equals("input")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
		}
		
		//test if element initial value is an empty string
		String tagValue = tagPassword.getAttribute("value");
		if (tagValue.equals("")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
        //test if placeholder equals simon
		String tagPlaceholder = tagPassword.getAttribute("placeholder");
		if (tagPlaceholder.equals("simon")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if maxlength equals 20
		String tagMaxlength = tagPassword.getAttribute("maxlength");
		if (tagMaxlength.equals("20")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if name equals password
		String tagAttrName = tagPassword.getAttribute("name");
		if (tagAttrName.equals("password")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
		
		//test if type equals password
		String tagAttrType = tagPassword.getAttribute("type");
		if (tagAttrType.equals("password")) {
//			Assert.success();
			System.out.println("test success!");
		} else {
//			Assert.fail();
			System.out.println("test fail!");
			return;
		}
	}

}
