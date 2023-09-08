package testScript;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
  @Test
  public void validLogin() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://the-internet.herokuapp.com/login");
	  
	  WebElement username = driver.findElement(By.id("username"));
	  username.sendKeys("tomsmith");
	  
	  WebElement password = driver.findElement(By.id("password"));
	  password.sendKeys("SuperSecretPassword!");
	  
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  WebElement success = driver.findElement(By.cssSelector("div.flash.success"));
	  wait.until(ExpectedConditions.visibilityOf(success));
	  boolean isDisp = success.isDisplayed();
	  System.out.println(success.getText());
	  Assert.assertTrue(isDisp);
	  
  }
}
