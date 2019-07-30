package com.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadingData {

	public static void main(String[] args) throws IOException
	{
		Properties pr = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Sirisha\\StockAccountingProject\\propertiesFile\\Environment.properties");
				
	       pr.load(fis);
        System.out.println("browser");
        System.out.println("admin");
        System.out.println("master");
	}

}
