package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class suppliers

{

	public static void main(String[] args) throws InterruptedException
	{

	      System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("http://webapp.qedge.com/login.php");
	      driver.manage().window().maximize();
	      Thread.sleep(2000);
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("admin");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("master");
	      
	      driver.findElement(By.xpath("//*[@id='btnsubmit']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//*[@id='mi_a_suppliers']/a")).click();
          driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
          driver.findElement(By.xpath("//*[@id='x_Supplier_Name']")).sendKeys("samsung");
          driver.findElement(By.xpath("//*[@id='x_Address']")).sendKeys("ameerpet");
          driver.findElement(By.xpath("//*[@id='x_City']")).sendKeys("hyd");
          driver.findElement(By.xpath("//*[@id='x_Country']")).sendKeys("india");
          driver.findElement(By.xpath("//*[@id='x_Contact_Person']")).sendKeys("xyaaa");
          driver.findElement(By.xpath("//*[@id='x_Phone_Number']")).sendKeys("987532119");
          driver.findElement(By.xpath("//*[@id='x__Email']")).sendKeys("xyz.123@gmail.com");
          driver.findElement(By.xpath("//*[@id='x_Mobile_Number']")).sendKeys("9877744345");
          driver.findElement(By.xpath("//*[@id='x_Notes']")).sendKeys("completed");
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[@id='btnAction']")).click();	
          driver.findElement(By.xpath("(//*[text()='OK!']")).click();
          driver.findElement(By.xpath("//*[@id='logout']")).submit();
          
        
	}

}
