package com.classes360;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Login_TestCase {
	public static WebDriver driver;
	
  
  @BeforeSuite(groups="Smoke")
  public static WebDriver setup_Browser() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "chromedriver81.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("file:///D:/AdminLTE/index.html");
	  return driver;
  }
  @Test(priority=1,groups="Regression",description="To Check project URL is Correct:")
  public static void Verify_Url() {
	  //Actual url
	  String my_url=driver.getCurrentUrl();
	  System.out.println("page title is"+my_url);
	  
	  //expected url
	  String expected_url="file:///D:/AdminLTE/index.html";
	  Assert.assertEquals(my_url, expected_url);
	  System.out.println("*****************************************");
	  System.out.println("Test case One with Thread Id:-"+Thread.currentThread().getId());
  }
  @Test(priority=2,groups="Regression",description="To verify Application Title:")
  public void verifyApplicationTitle() {
	  //Actual title
	  String my_title=driver.getTitle();
	  System.out.println("page title is"+my_title);
	  System.out.println(".................................");
	  //expected title
	  String expected_title="JavaByKiran | Log in";
	  Assert.assertEquals(my_title,expected_title);
	  System.out.println("****************************");
	  System.out.println("Test case two with thread Id:-"+Thread.currentThread().getId());
  }
  @Test(priority=3,groups="Regression",description="")
  public void verify_title() {
	  String stitle=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
	  String exp="Java By Kiran";
	  Assert.assertEquals(stitle, exp);
	  System.out.println("Application title verify"+stitle);
	  System.out.println("*****************************************");
  }
  //start log in session
  @Test(priority=4,groups="Regression")
  public void loginsession() {
	  driver.findElement(By.xpath("//p[contains(text(),'Sign in to start your session')]"));
	  System.out.println("Sign in to start your session");
	  System.out.println("**************************************************");
  }
  @Test(priority=5,groups="Regression")
  public void Check_PlaceHolder_Username() {
	  String str=driver.findElement(By.id("email")).getAttribute("placeholder");
	  String exp="Email";
	  Assert.assertEquals(str, exp);
	  System.out.println("placeholder Email-verified");
	  System.out.println("******************************");
  }
  @Test(priority=6,groups="Regression")
	  public void Check_PlaceHolder_Password() {
		  String str=driver.findElement(By.id("password")).getAttribute("placeholder");
		  String exp="Password";
		  Assert.assertEquals(str, exp);
		  System.out.println("placeholder password verified");
		  System.out.println("*************************************");
	  
   }
  @Test(priority=7,groups="Regression")
  	public void check_Button_color() {
	  WebElement signbtn=driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
	  System.out.println("before mouse over button color is "+signbtn.getCssValue("background-color"));
	  Actions act=new Actions(driver);
	  act.moveToElement(signbtn).build().perform();
	  System.out.println("after mouse over button color"+signbtn.getCssValue("color"));
	  System.out.println("********************************************");
  }
  @Test(priority=8,groups="Regression")
  public void check_Links() {
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  System.out.println("............................");
	  for(int i=0; i<links.size();i++) {
		  System.out.println(links.get(i).getText());
	  }
  }
  @Test(priority=9,groups="Regression")
  public void blank_username_password() {
	  WebElement stract=driver.findElement(By.xpath("//input[@id=\"email\"]"));
	  stract.sendKeys("");
	  String strexp="sa";
	  Assert.assertNotEquals(stract, strexp);
	  WebElement strpassword=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	  strpassword.sendKeys("");
	  String passexp="sa";
	  driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	  Assert.assertNotEquals(strpassword, passexp);
	  String uname=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	  System.out.println(uname);
	  String password=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
	  System.out.println(password);
	  System.out.println("....................................");
  }
  @Test(priority=10,groups="Regression")
  public void invalidusername_password() throws InterruptedException{
	  WebElement stract=driver.findElement(By.xpath("//input[@id=\"email\"]"));
	  stract.sendKeys("kks@gmail.com");
	  String strexp="kiran@gmail.com";
	  Assert.assertNotEquals(stract, strexp);
	  Thread.sleep(2000);
	  WebElement passact=driver.findElement(By.id("password"));
	  passact.sendKeys("123");
	  String passexp="123456";
	  Assert.assertNotEquals(passact, passexp);
	  driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block btn-flat\"]")).click();
	  System.out.println("Please enter email as kiran@gmail.com");
	  System.out.println("Please enter password as 123456");
	  System.out.println("********************************************");
  }
  @Test(priority=11,groups="Regression")
  public void valid_Username_Password() throws InterruptedException{
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-block btn-flat\"]")).click();
	  System.out.println("Valid username and password");
	  System.out.println("*****************************************");
	  
  }
  @Test(priority=12,groups="Smoke")
  public void Verify_Url_Dashboard() {
	  //Actual url
	  String my_url=driver.getCurrentUrl();
	  System.out.println("Page title is:"+my_url);
	  
	  //expected url
	  String expected_url="file:///D:/AdminLTE/pages/examples/dashboard.html";
	  Assert.assertEquals(my_url, expected_url);
	  System.out.println("********************************************");
  }
  @Test(priority=13,groups="Smoke")
  public void verifyApplicationTitle_Dashboard() {
	  //Actual title
	  String my_title=driver.getTitle();
	  System.out.println("page title is:"+my_title);
	  System.out.println("...........................................");
	  //Expected url
	  String expected_title="JavaByKiran | Dashboard";
	  Assert.assertEquals(my_title, expected_title);
	  System.out.println("********************************************");
  }
  @Test(priority=14,groups="Unit")
  public void click_OnUser() throws InterruptedException{
	  driver.findElement(By.xpath("//a[@href=\"users.html\"]")).click();
	  driver.findElement(By.xpath("//span[@class=\"label label-danger\"]")).click();
	  @SuppressWarnings("unused")
	  Alert at=driver.switchTo().alert();
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();	  
  }
  @AfterSuite
  public void afterSuite() {
  }

}
