package stock1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stock {
	String res;
	WebDriver driver;

	public String Applanuch(String url)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("http://webapp.qedge.com/login.php");
        driver.manage().window();
        if(driver.findElement(By.id("username")).isDisplayed())
        {
        	System.out.println("pass");
        	res="pass";
        }
        else
        {
        	System.out.println("fail");
        res="fail";
	}	
    return res;
   	
}


}



	

