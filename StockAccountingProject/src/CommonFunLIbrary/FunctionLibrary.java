package CommonFunLIbrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.propertyFileUtil;

public class FunctionLibrary 
{
	 WebDriver driver;
	      public static WebDriver startBrowser(WebDriver driver) throws IOException
	
	        {
	
		  if(propertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
				  {
		
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
			driver = new FirefoxDriver();
			
				  }else
		   if(propertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
		   {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			
		   }else
			if(propertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("IE"))
							
			{
			System.setProperty("webdriver.ie.driver"," D:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
						}
         
		                      return driver;
		
	}
        	  
          
//open application
	
	
	public static void openApplication(WebDriver driver) throws Throwable
	{
		driver.manage().window().maximize();
	driver.get(propertyFileUtil.getValueForKey("URL"));
	
	}
	public static void clickAction(WebDriver driver,String locatorType,String locatorValue)
	{
		if (locatorType.equalsIgnoreCase("id"))
		{
		   driver.findElement(By.id(locatorValue)).click();	
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorValue)).click();
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					driver.findElement(By.xpath(locatorValue)).click();
				}
	}
	
        //typeAction
		public static void typeAction(WebDriver driver,String locatorType,String locatorValue, String data)
		{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(data);
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorValue)).clear();
				driver.findElement(By.name(locatorValue)).sendKeys(data);
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					driver.findElement(By.xpath(locatorValue)).clear();
					driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				}
	
	
	
	}
public static void closeBrowser(WebDriver driver)	

{
	     driver.close();                                                                                                                                                                                                                                                       

}

    

//wait
public static void waitForElement(WebDriver driver,String locatorType,String locatorValue,String waittime)
{
	WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(waittime));
	if (locatorType.equalsIgnoreCase("id"))
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
	}else
	{
		if(locatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
	}else
	{
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		

		}
		}
}
}
//capture data on txt file
	public static void captureData(WebDriver driver,String locatorType,String locatorValue) throws IOException
	{
		String data="";
		if (locatorType.equalsIgnoreCase("id"))
		{
			    data= driver.findElement(By.id(locatorValue)).getAttribute("value");
			
		}else
			    if (locatorType.equalsIgnoreCase("name"))
			{ 
				data=driver.findElement(By.name(locatorValue)).getAttribute("value");
			
				}else
					if (locatorType.equalsIgnoreCase("xpath"))
					{ 
						data=driver.findElement(By.xpath(locatorValue)).getAttribute("value");
                      }
		FileWriter fw= new FileWriter("D:\\Sirisha\\StockAccountingProject\\captureData\\Data.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(data);
		bw.flush();
		bw.close();
	
	
}
	//mouse actions
	public static void pageDown(WebDriver driver)
	{
		Actions action  = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
	}
	public static void mouseAction(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		}
	public static void mouseHover(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
	}
	public static void stockCategories(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='mi_a_stock_items']/a"))).build().perform();	
		action.moveToElement(driver.findElement(By.xpath("//*[@id='mi_a_stock_categories']/a"))).click().build().perform();
	}
		
	public static void tableValidation(WebDriver driver, String colNum) throws Throwable
	{
		FileReader fr = new FileReader("D:\\Sirisha\\StockAccountingProject\\captureData\\Data.txt");
		BufferedReader br=new BufferedReader(fr);
		String exp_data=br.readLine();
		int colNum1=Integer.parseInt(colNum);
		if (driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).isDisplayed())
	{
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).clear();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).sendKeys(exp_data);	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.button"))).click();	
	}
		else
		{
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.panel"))).click();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).clear();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).sendKeys(exp_data);	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.button"))).click();
	
	}
		WebElement webtable = driver.findElement(By.xpath(propertyFileUtil.getValueForKey("webtable.path")));
		List<WebElement>rows=webtable.findElements(By.tagName("tr"));
		for (int i = 0; i <=rows.size(); i++)
		{
			String act_Data=driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/form/div/div//table[@id='tbl_a_supplierslist']/tbody/tr[1]/td[6]/div/span/span")).getText();
		      System.out.println(act_Data);
			Assert.assertEquals(exp_data,act_Data);
		      break;
		}
		
	}
	//mouse click
	public void mouseClick(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='mi_a_stock_items']"))).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=mi_a_stock_categories']"))).click().build().perform();
	}
	
	//genarate date
	public static String generateDate()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_mm_dd_ss");
		return sdf.format(date);
		
		}
	

//table valiodation 
public static void tableValidation1(WebDriver driver, String exp_data) throws Throwable

{
	if (driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).isDisplayed())
	{
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).clear();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).sendKeys(exp_data);	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.button"))).click();	
	}
		else
		{
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.panel"))).click();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).clear();	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.box"))).sendKeys(exp_data);	
		  driver.findElement(By.xpath(propertyFileUtil.getValueForKey("search.button"))).click();
	
	}
		WebElement webtable = driver.findElement(By.xpath(propertyFileUtil.getValueForKey("webtable.path1")));
		List<WebElement>rows=webtable.findElements(By.tagName("tr"));
		for (int i = 0; i <=rows.size(); i++)
		{
			String act_Data=driver.findElement(By.xpath("//*[@id='tb1_a_stock_categorieslist']/tbody/tr["+i+"]/td[4]/div/span/span")).getText();
			  System.out.println(act_Data);
		      Assert.assertEquals(exp_data,act_Data);
		      break;
		}
		
		
	}
}
