package DemoBlazeTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageClassTest extends BaseTestClass {

	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}

	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void firstTest() {
		demoBlazePageClass.openLoginModal();// Otvori login modal
		demoBlazePageClass.isLoginModalVisible();// Proveri da je modal prikazan
		demoBlazePageClass.loginUsername("Nikola");// Unesi korisničko ime i lozinku
		demoBlazePageClass.loginPassword("test123");
		demoBlazePageClass.clickButtonLogin();// Klikni na dugme Login
		demoBlazePageClass.getErrorMessage();// Proveri error poruku (ako postoji)
	}
}
