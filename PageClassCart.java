package DemoBlazeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import java.util.concurrent.TimeoutException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClassCart {
	WebDriverWait wait;
	WebDriver driver;

	public PageClassCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Klik na prvi proizvod u listi proizvoda
	@FindBy(css = "#tbodyid > div:nth-child(1) > div > div > h4 > a")
	WebElement clickFirstSection;

	// Klik na "Add to cart" i hvatanje JavaScript alert-a
	@FindBy(css = "#tbodyid > div.row > div > a")
	WebElement clickAddToCart;

	// Klik na ikonicu "Cart" u navigacij
	@FindBy(css = "#cartur")
	WebElement clickCart;

	// Provera da li je prikazana slika proizvoda u tabeli (cart)
	@FindBy(css = "#tbodyid > tr > td:nth-child(1) > img")
	WebElement checkTableImg;

	// Klik na dugme "Place Order"
	@FindBy(css = "#page-wrapper > div > div.col-lg-1 > button")
	WebElement clickPlaceOrder;

	// Provera da li je modal za porudžbinu prikazan
	@FindBy(css = "#orderModal > div > div")
	WebElement modalCartShow;

	// Unos imena u formu
	@FindBy(css = "#name")
	WebElement inputName;

	// Unos zemlje
	@FindBy(css = "#country")
	WebElement choseCountry;

	// Unos grada
	@FindBy(css = "#city")
	WebElement choseCity;

	// Unos broja kartice
	@FindBy(xpath = "//*[@id=\"card\"]")
	WebElement selectCard;

	// Unos meseca
	@FindBy(css = "#month")
	WebElement inputMonth;

	// Unos godine
	@FindBy(css = "#year")
	WebElement inputYear;

	// Klik na dugme "Purchase" u modalu
	@FindBy(css = "#orderModal > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement buttonPurchase;

	// Provera da li se SweetAlert modal prikazao (porudžbina uspešna)
	@FindBy(css = "body > div.sweet-alert.showSweetAlert.visible")
	WebElement messageAfterClickPurchase;

	// Provera da li se prikazuje success ikonica (checkmark)
	@FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > div.sa-icon.sa-success.animate > div.sa-placeholder")
	WebElement checkChecked;

	// Čekanje na pojavu SweetAlert naslova i vraćanje teksta
	@FindBy(css = "h2")
	WebElement sweetAlertTitle;

	// Čekanje da se SweetAlert pojavi (vrati true/false)
	@FindBy(css = "p.lead.text-muted")
	WebElement sweetAlertText;

	// Dohvatanje celog teksta iz SweetAlert-a
	@FindBy(css = ".confirm.btn.btn-lg.btn-primary")
	WebElement sweetAlertButton;

	// Metod

	// Klik na prvi proizvod u listi proizvoda
	public void firstSectionClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickFirstSection)).click();
	}

	// Klik na "Add to cart" i hvatanje JavaScript alert-a
	public void clickAddToCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickAddToCart)).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("ALERT text: " + alert.getText());
		alert.accept();
	}

	// Klik na ikonicu "Cart" u navigaciji
	public void cartClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickCart)).click();
	}

	// Provera da li je prikazana slika proizvoda u tabeli (cart)
	public boolean showImg() {
		return wait.until(ExpectedConditions.visibilityOf(checkTableImg)).isDisplayed();
	}

	// Klik na dugme "Place Order"
	public void placeOrderClick() {
		// wait.until(ExpectedConditions.elementToBeClickable(clickPlaceOrder)).click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickPlaceOrder)).click();
			System.out.println("Place Order button clicked...");
		} catch (TimeoutException e) {
			System.out.println("Place order button not clickable");
			throw e;
		}
	}

	// Provera da li je modal za porudžbinu prikazan
	public boolean isCartModalVisible() {
		// return
		// wait.until(ExpectedConditions.visibilityOf(modalCartShow)).isDisplayed();
		try {
			return wait.until(ExpectedConditions.visibilityOf(modalCartShow)).isDisplayed();
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("⚠️ Order modal NIJE prikazan na vreme.");
			return false;
		}
	}

	// Unos imena u formu
	public void placeOrderName(String username) {
		inputName.sendKeys(username);
		inputName.click();
	}

	// Unos zemlje
	public void inputCountry(String country) {
		choseCountry.sendKeys(country);
		choseCountry.click();
	}

	// Unos grada
	public void inputCity(String city) {
		choseCity.sendKeys(city);
		choseCity.click();
	}

	// Unos broja kartice
	public void creditCard(String card) {
		selectCard.sendKeys(card);
		selectCard.click();
	}

	// Unos meseca
	public void iputFieldMonth(String month) {
		inputMonth.sendKeys(month);
		inputMonth.click();
	}

	// Unos godine
	public void inputFieldYear(String year) {
		inputYear.sendKeys(year);
		inputYear.click();
	}

	// Klik na dugme "Purchase" u modalu
	public void clickButtonPurchase() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonPurchase)).click();
	}

	// Provera da li se SweetAlert modal prikazao (porudžbina uspešna)
	public boolean messageModal() {
		// return
		// wait.until(ExpectedConditions.visibilityOf(messageAfterClickPurchase)).isDisplayed();
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("div.sweet-alert.showSweetAlert.visible")));
			return true;
		} catch (TimeoutException e) {
			System.out.println("⚠️ SweetAlert se nije pojavio na vreme.");
			return false;
		}
	}

	// Provera da li se prikazuje success ikonica (checkmark)
	public boolean smallImg() {
		return wait.until(ExpectedConditions.visibilityOf(checkChecked)).isDisplayed();
	}

	// Čekanje na pojavu SweetAlert naslova i vraćanje teksta
	public String getSweetAlertTitle() {
		// return
		// wait.until(ExpectedConditions.visibilityOf(sweetAlertTitle)).getText();
		// wait.until(ExpectedConditions.visibilityOf(messageAfterClickPurchase));
		// sweetAlertTitle.getText();
		if (!waitForSweetAlertToAppear()) {
			throw new RuntimeException("❌ SweetAlert nije se pojavio — verovatno nije uspešna kupovina.");
		}

		WebElement alertTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sweet-alert h2")));
		return alertTitle.getText();
	}

	// Čekanje da se SweetAlert pojavi (vrati true/false)
	public boolean waitForSweetAlertToAppear() {
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("div.sweet-alert.showSweetAlert.visible")));
			return true;
		} catch (TimeoutException e) {
			System.out.println("SweetAlert nije prikazan.");
			return false;
		}
	}

	// Dohvatanje celog teksta iz SweetAlert-a
	public String getSweetAlertText() {
		// return wait.until(ExpectedConditions.visibilityOf(sweetAlertText)).getText();
		WebElement alertText = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sweet-alert p.lead.text-muted")));
		return alertText.getText();
	}

	// Klik na "OK" dugme unutar SweetAlert modala
	public void getSweetAlertButton() {
		WebElement okButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sweet-alert button.confirm")));
		okButton.click();
	}

	// Parsiranje vrednosti iz SweetAlert teksta po ključu
	private String extractFieldValue(String fullText, String fieldName) {
		for (String line : fullText.split("\n")) {
			if (line.startsWith(fieldName + ":")) {
				return line.replace(fieldName + ":", "").trim();
			}
		}
		return null;
	}

	// Parsiranje ID vrednosti iz porudžbine
	public String getPurchaseId() {
		return extractFieldValue(getSweetAlertText(), "Id");
	}

	// Parsiranje amount vrednosti (npr. "360 USD")
	public String getAmount() {
		return extractFieldValue(getSweetAlertText(), "Amount");
	}

	// Parsiranje kartice (Card Number)
	public String getCardNumber() {
		return extractFieldValue(getSweetAlertText(), "Card Number");
	}

	// Parsiranje imena
	public String getName() {
		return extractFieldValue(getSweetAlertText(), "Name");
	}

	// Parsiranje datuma
	public String getDate() {
		return extractFieldValue(getSweetAlertText(), "Date");
	}
}
