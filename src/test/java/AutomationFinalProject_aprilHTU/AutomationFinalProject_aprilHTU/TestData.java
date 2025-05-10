package AutomationFinalProject_aprilHTU.AutomationFinalProject_aprilHTU;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	
	WebDriver driver = new ChromeDriver();
	String TheURL = "https://www.almosafer.com/en";

	Random rand = new Random();
	String ExpectedLanaguage = "en";

	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	String ExpectedValueForHotelTab = "false";
	LocalDate today = LocalDate.now();
	int Tomorrow = today.plusDays(1).getDayOfMonth();
	String ExpectedDepatureDate = String.format("%02d", Tomorrow);
	int TheDayAfterTomorrow = today.plusDays(2).getDayOfMonth();

	String ExpectedReturnDate = String.format("%02d", TheDayAfterTomorrow);

	String[] Websites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	int RandomWebsite = rand.nextInt(Websites.length);
	String ExpectedLanaguageAr = "ar";
	String[] EnglishCities = { "dubai", "jeddah", "riyadh" };
	int randomEnglish = rand.nextInt(EnglishCities.length);
	String[] ArabicCities = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(ArabicCities.length);
	JavascriptExecutor js = (JavascriptExecutor) driver;

public void Setup() {
	driver.get(TheURL);

	driver.manage().window().maximize();
	WebElement SelectCountry = driver.findElement(By.cssSelector(".cta__button.cta__saudi.btn.btn-primary"));
	SelectCountry.click();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
}

}
