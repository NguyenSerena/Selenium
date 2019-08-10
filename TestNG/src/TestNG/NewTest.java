package TestNG;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class NewTest {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "E:\\Selenium\\chromedriver.exe";
    public WebDriver driver ;
    
  @Test
  public void verifyHomepageTitle() {
      
      System.out.println("launching chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
  
}
