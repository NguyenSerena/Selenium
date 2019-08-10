package TestNG;

//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class zingme3 {
	public String url = "http://login.me.zing.vn/";
	public WebDriver driver;
	public String chrome_url = "E:\\Selenium\\chromedriver.exe";
	 
	 

	@BeforeTest
	public void beforeTest() {
	
		System.setProperty("webdriver.chrome.driver", chrome_url);
		driver = new ChromeDriver();
		driver.manage().window().maximize();	

		driver.get(url);
		System.out.println("khoi dong chrome driver");
	}

	@Test(priority = 0)
	public void title() {
		String expecttitle = "Zing Me - Mạng xã hội & giải trí online lớn nhất Việt Nam";
		String actualtitle = driver.getTitle();
		if (actualtitle.contentEquals(expecttitle)) {
			System.out.println(actualtitle);
		} else {

			System.out.println("title khong dung");
		}

	}

	@Test(priority = 1)
	public void login() {
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.id("u"));
		user.clear();
		user.sendKeys("Selenaback");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement pass = driver.findElement(By.id("pp"));
		pass.clear();
		pass.sendKeys("Nguyen1011");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement remember = driver.findElement(By.className("checkbox"));
		if (!remember.isSelected()) {
			remember.click();
		}
		
		driver.findElement(By.id("btnLogin")).click();
		
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

		// set time sau khi login
		String url_succ = driver.getCurrentUrl();
		System.out.println(url_succ);

	
	}

	@Test(priority = 2)
	public void logig_tc() {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	String news = driver.findElement(By.linkText("selenaback")).getText();
	System.out.println(news);
	
	//System.out.println(driver.getTitle());
	//System.out.println(driver.getCurrentUrl());
	String expecttitle2 = "selenaback trên Zing Me";
	String actualtitle2 = driver.getTitle();
	if (actualtitle2.contentEquals(expecttitle2)) {
		System.out.println("thanh cong:" +expecttitle2);
	} else
	System.out.println(actualtitle2);
	
		
	//	String actualUrl="http://me.zing.vn/h/selenaback?utm_source=me.login";

	//	String expectedUrl= driver.getCurrentUrl();

	//	Assert.assertEquals(expectedUrl,actualUrl);
	//driver.navigate().to("http://me.zing.vn/h/selenaback?utm_source=me.login");
		//expecttitle = "selenaback trên Zing Me";
//		String expecttitle2 = "selenaback trên Zing Me";
//		String actualtitle2 = driver.getTitle();
//		actualtitle2 = driver.getTitle();
//	//	actualtitle = driver.getTitle();
//		//Assert.assertEquals(actualtitle, expecttitle);
//		if (actualtitle2.equals(expecttitle2))
//		{
//		System.out.println( "Test Passed") ;
//		}
//		else {
//		System.out.println(actualtitle2);
//		driver.close();
//		}
		//if (actualtitle2.contentEquals(expeclogin)) {
		//System.out.println("Title la dung:" + expeclogin);

	//	} else {
	//	System.out.println("title:" +actualtitle);
	//	}

	}
	//@Test(priority = 3)
	/*public void coki() {
		// set cookie cho remember login
				Set<Cookie> cookie = driver.manage().getCookies();
				for (Cookie coookie : cookie) {
					driver.manage().addCookie(coookie);
				}
	}*/

	@AfterTest
	public void aftertest() {
		
		System.out.println("da close");
		driver.close();
	}
  
}
