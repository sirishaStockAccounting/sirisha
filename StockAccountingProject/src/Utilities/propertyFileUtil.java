package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;



public class propertyFileUtil
{
	public static String getValueForKey(String Key) throws IOException
	{
	
	Properties configProperties = new Properties();
	FileInputStream fis = new FileInputStream("D:\\Sirisha\\StockAccountingProject\\propertiesFile\\Environment.properties");
	configProperties.load(fis);
			
      return configProperties.getProperty(Key);
}


}