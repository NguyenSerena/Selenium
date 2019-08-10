package TestNG;

import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class zingme1 {

	public String url = "http://login.me.zing.vn/";
	WebDriver driver;
	public String chrome_url = "E:\\Selenium\\chromedriver.exe";

	public String actualtitle = driver.getTitle();

	@BeforeTest
	public void beforetest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", chrome_url);
		System.out.println("khoi dong chrome driver");
		driver.get(url);

	}

	@Test(priority = 0)
	public void title() {
		String expecttitle = "Zing Me - Mạng xã hội & giải trí online lớn nhất Việt Nam";
		// String actualtitle = driver.getTitle();
		if (actualtitle.contentEquals(expecttitle)) {
			System.out.println(actualtitle);
		} else {

			System.out.println("title khong dung");
		}

	}

	@Test(priority = 1)
	public void login() {

		WebElement user = driver.findElement(By.id("u"));
		user.clear();
		user.sendKeys("Selenaback");
		WebElement pass = driver.findElement(By.id("pp"));
		pass.clear();
		user.sendKeys("Nguyen1011@");

		WebElement remember = driver.findElement(By.className("checkbox"));
		if (!remember.isSelected()) {
			remember.click();
		}

		driver.findElement(By.id("btnLogin")).click();

		// set time sau khi login
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void logig_tc() {
		String expeclogin = "selenaback trên Zing Me";
		if (actualtitle.contentEquals(expeclogin)) {
			System.out.println("Title la:" + expeclogin);

		} else {
			System.out.println("loi login");
		}

	}

	@AfterTest
	public void aftertest() {

		// set cookie cho remember login
		Set<Cookie> cookie = driver.manage().getCookies();
		for (Cookie coookie : cookie) {
			driver.manage().addCookie(coookie);
		}

		driver.close();
	}

}
