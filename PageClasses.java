package DemoBlazeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClasses {
	WebDriver driver;
	WebDriverWait wait;

	public PageClasses(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Elementi
	// Klik na "Login" dugme u navigaciji
	@FindBy(id = "login2")
	WebElement loginButton;

	// Provera da li je prikazan login modal
	@FindBy(css = "#logInModal > div > div")
	WebElement modalLoginShow;

	// Unos korisničkog imena u modal
	@FindBy(css = "#loginusername")
	WebElement usernameInput;

	// Unos lozinke u modal
	@FindBy(css = "#loginpassword")
	WebElement passwordInput;

	// Klik na "Log in" dugme u login modalu
	@FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement loginConfirmButton;

	// Uzimanje error poruke nakon neuspešnog logovanja
	@FindBy(css = "#errorl")
	WebElement errorLabel;

	// Metod

	// Klik na "Login" dugme u navigaciji
	public void openLoginModal() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	// Provera da li je prikazan login modal
	public boolean isLoginModalVisible() {
		return wait.until(ExpectedConditions.visibilityOf(modalLoginShow)).isDisplayed();
	}

	// Unos korisničkog imena u modal
	public void loginUsername(String username) {
		usernameInput.sendKeys(username);
		usernameInput.click();
	}

	// Unos lozinke u modal
	public void loginPassword(String password) {
		passwordInput.sendKeys(password);
		passwordInput.click();
	}

	// Klik na "Log in" dugme u login modalu
	public String getErrorMessage() {
		return errorLabel.getText();
	}

	// Uzimanje error poruke nakon neuspešnog logovanja
	public void clickButtonLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginConfirmButton)).click();
	}

}
