package DemoBlazeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	WebDriver driver;

	PageClasses demoBlazePageClass;
	PageClassCart demoBlazeCart;

	@BeforeTest
	public void initalization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		demoBlazePageClass = new PageClasses(driver);
		demoBlazeCart = new PageClassCart(driver);
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
