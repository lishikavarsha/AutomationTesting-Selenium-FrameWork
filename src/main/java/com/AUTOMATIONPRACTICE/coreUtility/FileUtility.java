package com.AUTOMATIONPRACTICE.coreUtility;





	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	/**
	 * This class contains only property file specific common methods
	 * @author Roopa
	 *
	 */


	public class FileUtility {
		
		/**
		 *  This method is used to open the propertyfile
		 */
		static Properties property=null;

		public static void openPropertyFile(String filepath) throws IOException 
		{

			FileInputStream file=new FileInputStream(filepath);
			property=new Properties();
			property.load(file);
			
		}
			
		/**
		 * this method is used to fetch the data from the property file
		 * @param key
		 * @return
		 */
		public static String getDataFromPropertyFile(String key)
		{
			
			return property.getProperty(key);

		}

	




}
