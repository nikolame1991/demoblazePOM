package DemoBlazeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageClassCartTest extends BaseTestClass {

	// Pre svakog testa otvori početnu stranicu
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}

	// Očisti kolačiće posle svakog testa
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@Test // POZITIVAN TEST: Kupovina sa validnim podacima
	public void secondClickSelect() {
		demoBlazeCart.firstSectionClick(); // Klikni proizvod
		demoBlazeCart.clickAddToCart(); // Dodaj u korpu
		demoBlazeCart.cartClick(); // Otvori korpu i proveri da je proizvod tu
		assertTrue(demoBlazeCart.showImg(), "Cart image nije prikazana.");

		demoBlazeCart.placeOrderClick(); // Klikni "Place Order"
		assertTrue(demoBlazeCart.isCartModalVisible(), "Order modal nije prikazan!");

		// Popuni formu
		demoBlazeCart.placeOrderName("Nikola");
		demoBlazeCart.inputCountry("Canada");
		demoBlazeCart.inputCity("Toronto");
		demoBlazeCart.creditCard("Master");
		demoBlazeCart.iputFieldMonth("June");
		demoBlazeCart.inputFieldYear("1980");
		demoBlazeCart.clickButtonPurchase(); // Klikni "Purchase"

		assertTrue(demoBlazeCart.waitForSweetAlertToAppear(), "SweetAlert nije prikazan!"); // Čekaj SweetAlert

		assertTrue(demoBlazeCart.smallImg(), "Success ikonica nije vidljiva!");
		assertEquals(demoBlazeCart.getSweetAlertTitle(), "Thank you for your purchase!");

		String id = demoBlazeCart.getPurchaseId(); // Klikni "Purchase"
		String amount = demoBlazeCart.getAmount();
		String card = demoBlazeCart.getCardNumber();
		String name = demoBlazeCart.getName();
		String date = demoBlazeCart.getDate();
		// Parsiraj podatke iz porudžbine
		System.out.println("🧾 Order Details:");
		System.out.println("ID: " + id);
		System.out.println("Amount: " + amount);
		System.out.println("Card: " + card);
		System.out.println("Name: " + name);
		System.out.println("Date: " + date);
		// Validiraj vrednosti
		assertTrue(amount.endsWith("USD"), "Amount format nije ispravan!");
		assertEquals(name, "Nikola", "Ime kupca nije tačno!");
		// Klikni OK u alertu
		demoBlazeCart.getSweetAlertButton();
	}

	@Test // NEGATIVAN TEST: Klik na "Purchase" bez unosa podataka
	public void testEmptyPurchaseFormDoesNotShowAlert() {
		demoBlazeCart.firstSectionClick();// Dodaj proizvod
		demoBlazeCart.clickAddToCart();// Otvori korpu
		demoBlazeCart.cartClick();// Klikni "Place Order"
		assertTrue(demoBlazeCart.showImg(), "Cart je prazan!"); // Mala slika je vidljiva

		demoBlazeCart.placeOrderClick();// Ne unosi ništa u formu
		assertTrue(demoBlazeCart.isCartModalVisible(), "Modal nije prikazan");

		demoBlazeCart.clickButtonPurchase();// Klikni "Purchase"

		boolean alertShow = demoBlazeCart.waitForSweetAlertToAppear();// Uveri se da se SweetAlert NE pojavljuje
		assertFalse(alertShow, "SweetAlert je prikazan iako forma nije popunjena");
	}
}
