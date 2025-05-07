package AutomationFinalProject_aprilHTU.AutomationFinalProject_aprilHTU;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	WebDriver driver = new ChromeDriver();
	String TheURL = "https://www.almosafer.com/en";

	@BeforeTest
	public void mySetup() {

		driver.get(TheURL);

		driver.manage().window().maximize();
		WebElement SelectCountry = driver.findElement(By.cssSelector(".cta__button.cta__saudi.btn.btn-primary"));
		SelectCountry.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void CheckWebSiteLanaguage() {
		String ExpectedLanaguage = "en";

		String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActualLanaguge, ExpectedLanaguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)

	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.cssSelector(".sc-cjHlYL.gdvIKd")).getText();
		String ExpectedContactNumber = "+966554400000";

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		WebElement QitafLogo = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.tagName("svg"));

		boolean ActualResultForQitafLogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResultForQitafLogo, true);
	}

	@Test(priority = 5, enabled = false)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValueForHotelTab = HotelTab.getDomAttribute("aria-selected");
		String ExpectedValue = "false";

		Assert.assertEquals(ActualValueForHotelTab, ExpectedValue);

	}

	@Test(priority = 6, enabled = true)
	public void FLightDepatureDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualDepatureDate = dates.get(0).getText();

		LocalDate today = LocalDate.now();

		int Tomorrow = today.plusDays(1).getDayOfMonth();

		String ExpectedDepatureDate = String.format("%02d", Tomorrow);

		System.out.println(ExpectedDepatureDate);
		System.out.println(ActualDepatureDate);

		Assert.assertEquals(ActualDepatureDate, ExpectedDepatureDate);

	}

	@Test(priority = 7, enabled = true)
	public void FlightReturnDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualReturnDate = dates.get(1).getText();

		LocalDate today = LocalDate.now();

		int TheDayAfterTomorrow = today.plusDays(2).getDayOfMonth();

		String ExpectedReturnDate = String.format("%02d", TheDayAfterTomorrow);

		System.out.println(ExpectedReturnDate);
		System.out.println(ActualReturnDate);

		Assert.assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	@Test(priority = 8, enabled = false)
	public void ChangeTheWebsiteLanaguage() {

	}

	@Test(priority = 9, enabled = false)
	public void RandomlySelectCity() {

	}

	@Test(priority = 10, enabled = false)
	public void CheckTheResultsIsretrived() {

	}

	@AfterTest
	public void AfterMyTest() {

	}

}
