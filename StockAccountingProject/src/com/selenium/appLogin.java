package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class appLogin {

	public static void main(String[] args) throws InterruptedException
	{
      System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
      WebDriver driver = new FirefoxDriver();
      driver.get("http://webapp.qedge.com/login.php");
      Thread.sleep(2000);
      driver.findElement(By.id("username")).clear();
      driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.id("password")).clear();
      driver.findElement(By.id("password")).sendKeys("master");
      
      driver.findElement(By.id("btnsubmit")).click();
      //appLogout
      driver.findElement(By.id("logout")).click();
     /* driver.findElement(By.xpath("//a[@id=Logout]")).click();*/
     driver.findElement(By.xpath("//*[text()='OK!']")).click();
	}
	

}
