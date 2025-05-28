# DemoBlaze Automation Testing Project

This project contains automated UI tests for the [DemoBlaze](https://www.demoblaze.com/) website using:
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)**
- **Explicit and Implicit Waits**

---

## 📌 Project Structure

DemoBlazeAutomation/
├── src/
│ └── test/
│ ├── java/
│ │ └── DemoBlazeTest/
│ │ ├── base/BaseTest.java
│ │ ├── pages/
│ │ │ ├── HomePage.java
│ │ │ ├── ProductPage.java
│ │ │ ├── CartPage.java
│ │ │ └── PlaceOrderPage.java
│ │ ├── tests/
│ │ │ ├── PurchaseFlowTest.java
│ │ │ └── AlertValidationTest.java
│ │ └── utils/
│ │ └── TestDataProvider.java
├── pom.xml
└── README.md

---

## ✅ Features Covered

- 🛒 Add product to cart
- 🧾 Complete purchase flow
- 🚫 Validate required field alert
- 🎯 Verify purchase success message
- 🔄 Wait handling with WebDriverWait

---

## 🚀 How to Run the Tests

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/DemoBlazeAutomation.git
2. Open the project in IntelliJ or Eclipse

3. Make sure dependencies are installed (via Maven or manually)

4. Run the test suite using TestNG

🔧 Tech Stack

   - Java 21

   - Selenium 4.22

   - TestNG

   - Maven

   - ChromeDriver

🧪 Sample Test Scenario

@Test
public void testEmptyPurchaseFormShowsAlert() {
    cartPage.clickPlaceOrder();
    String alertText = cartPage.getSweetAlertMessage();
    Assert.assertEquals(alertText, "Please fill out Name and Creditcard.");
}

📎 Author

Nikola Medan
📧 nikolamedan1991@gmail.com
📍 Novi Sad, Serbia
🔗 LinkedIn
🔗 GitHub
