package TestNG;


import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class xpersity {
							
				
		public String baseUrl = "https://landing-xpersity-dev.firebaseapp.com/";		
		String driverPath = "E:\\Selenium\\chromedriver.exe";		
		public WebDriver driver;		
		public String expecttitle = null;		
		public String actualtitle = null;		
				
		@BeforeTest		
		public void beforeTest() {		
			System.out.println("welcome chrome");	
			System.setProperty("webdriver.chrome.driver", driverPath);	
			driver = new ChromeDriver();	
			driver.manage().window().maximize();	
			driver.get(baseUrl);	
		}		
		@Test(priority = 0)		
		public void Become_an_Expert() {		
			driver.findElement(By.linkText("Become an Expert")).click();	
			expecttitle = "Xpersity: Expert Registration";	
			actualtitle = driver.getTitle();	
			Assert.assertEquals(actualtitle, expecttitle);	
				
		}		
		@Test(priority = 1)		
		public void tick_apply() {		
			driver.findElement(By.id("check-terms-of-use")).click();	
				
			driver.findElement(By.id("check-privacy-policy")).click();	
			System.out.println("check click okies");	
		}		
		@Test(priority = 2)		
		public void click_apply() {		
			driver.findElement(By.id("apply-without-linkedin")).click();	
			System.out.println("apply complete");	
		}		
		@Test(priority = 3)		
		public void input_value() throws Exception {		
			driver.findElement(By.id("firstName")).sendKeys("Selena");	
			driver.findElement(By.id("lastName")).sendKeys("nguyen");	
			driver.findElement(By.id("email")).sendKeys("thaonguyenduong.td@gmail.com");	
				
			WebElement upload = driver.findElement(By.className("chooseImage"));
	
			upload.click();
			Runtime.getRuntime().exec("E:\\Selenium\\AutoIT\\upload_file.exe");

			//upload.sendKeys("E:\\channel.png");
			//upload.getText();
			//driver.switchTo().window(driver.getWindowHandle());
			// cach1 with upload file la buton and textbox
			//driver.findElement(By.name("File name")).sendKeys("E:\\channel.png");
			

			//upload.findElement(By.name("Open")).click();
				System.out.println("upload file thanh cong");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
				driver.findElement(By.id("btn-next")).click();
					
	}	
		@Test(priority = 4)		
		public void About_you() {
			driver.findElement(By.id("aboutYouself")).sendKeys("Describe your professional or academic experience and domain knowledge that demonstrate your expertise and ability to advise/mentor. (up to 1,500 characters)");
			driver.findElement(By.id("knowledge")).sendKeys("Please give a list of your areas of expertise and knowledge (e.g., sectors, functions, gepgraphic markets)");
			// select option
			Select drpname = new Select(driver.findElement(By.id("displayName")));
			drpname.selectByVisibleText("Selena");
			
			System.out.println("about you thanh cong");
			
			driver.findElement(By.id("btn-credentials")).click();
			
		}
		@Test(priority = 5)
		public void next() {
			driver.findElement(By.id("btn-credentials"));
			System.out.println("click next lan 2");
		}
		
		@Test(priority = 6)
		public void credentials() {
			driver.findElement(By.id("currentCompany")).sendKeys("Google");
			driver.findElement(By.id("currentTitle")).sendKeys("Director");
			driver.findElement(By.id("pastCompanies")).sendKeys("Organizations");
			driver.findElement(By.id("academic")).sendKeys("Ex: Harvard, Oxford, Seoul National University");
			driver.findElement(By.id("majors")).sendKeys("Ex: PhD in Economics, MS in Computer Science, BS in Architecture");
			
			WebElement seletor = driver.findElement(By.id("languages"));
			seletor.sendKeys("English");
			//Select drlanguage = new Select(seletor);
			//drlanguage.selectByVisibleText("English");
			//drlanguage.selectByVisibleText("English");
			
			driver.findElement(By.id("otherCredentials")).sendKeys("https://landing-xpersity-dev.firebaseapp.com/formRegister.html");
			driver.findElement(By.id("btn-submit-manual")).click();
			System.out.println("credentials thanh cong");
		}
		
		@Test(priority = 7)
		public void popupsubmit() {
			
			/*Alert popup = driver.switchTo().alert();
			String messagepopup = driver.switchTo().alert().getText();
			
			System.out.println(messagepopup);
			popup.accept(); */
			// set time cho doi cho api load popup
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// tim element sau khi thoi gian doi
				driver.findElement(By.id("close-modal-success")).click();
				
				if (driver.getTitle().equals("Xpersity")) {							
		            System.out.println("We are back at home");					
		        } else {			
		            System.out.println("We are NOT in home");					
		        }		
			
			
		
		}
		@AfterTest		
		public void closer() {		
	//	driver.close();	
		}		
	}			
				

