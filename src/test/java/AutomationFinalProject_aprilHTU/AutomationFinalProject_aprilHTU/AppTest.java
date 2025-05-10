package AutomationFinalProject_aprilHTU.AutomationFinalProject_aprilHTU;

import static org.testng.Assert.assertEquals;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest
	public void mySetup() {
		Setup();

	}

	@Test(priority = 1, enabled = true)
	public void CheckWebSiteLanaguage() {
		String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActualLanaguge, ExpectedLanaguage);

	}

	@Test(priority = 2, enabled = true)
	public void CheckCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = true)

	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.cssSelector(".sc-cjHlYL.gdvIKd")).getText();

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4, enabled = true)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		WebElement QitafLogo = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.tagName("svg"));

		boolean ActualResultForQitafLogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResultForQitafLogo, true);
	}

	@Test(priority = 5, enabled = true)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValueForHotelTab = HotelTab.getDomAttribute("aria-selected");

		Assert.assertEquals(ActualValueForHotelTab, ExpectedValueForHotelTab);

	}

	@Test(priority = 6, enabled = true)
	public void FLightDepatureDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = dates.get(0).getText();
		Assert.assertEquals(ActualDepatureDate, ExpectedDepatureDate);

	}

	@Test(priority = 7, enabled = true)
	public void FlightReturnDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		Assert.assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	@Test(priority = 8, enabled = true)
	public void ChangeTheWebsiteLanaguage() throws InterruptedException {
		Thread.sleep(2000);

		driver.get(Websites[RandomWebsite]);

		if (driver.getCurrentUrl().contains("en")) {
			String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanaguge, ExpectedLanaguage);
		} else {
			String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanaguge, ExpectedLanaguageAr);
		}

	}

	@Test(priority = 9, enabled = true)
	public void RandomlySelectCity() {

		WebElement hotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelTab.click();

		WebElement SearchInput = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (driver.getCurrentUrl().contains("en")) {
			SearchInput.sendKeys(EnglishCities[randomEnglish] + Keys.ENTER);
		} else {
			SearchInput.sendKeys(ArabicCities[randomArabicCity] + Keys.ENTER);

		}

		// OR to click on the first Li in the UnorderdList UL
		// WebElement UnorderedList =
		// driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

		// UnorderedList.findElements(By.tagName("li")).get(1).click();

		WebElement numberOfVistor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select mySelect = new Select(numberOfVistor);
		int selectOption = rand.nextInt(2);
		mySelect.selectByIndex(selectOption);
		
		WebElement SearchHotelButton = driver
				.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));

		SearchHotelButton.click();
	}

	@Test(priority = 10, enabled = true)
	public void CheckTheResultIsretrived() {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement resultsElement = wait.until(ExpectedConditions.presenceOfElementLocated(
//			    By.xpath("//span[@data-testid='srp_properties_found']")));
//		
//		String Results = resultsElement.getText();
//
//		boolean ActualResult =Results.contains("مكان") || Results.contains("stays");
//		boolean ExpectedResult = true ; 
//
//		Assert.assertEquals(ActualResult, ExpectedResult);

		// or


		// Get and print the readyState
		String pageState = (String) js.executeScript("return document.readyState");
		
		System.out.println(pageState);
		assertEquals(pageState, "complete");

	}

	@AfterTest
	public void AfterMyTest() {

	}

}
