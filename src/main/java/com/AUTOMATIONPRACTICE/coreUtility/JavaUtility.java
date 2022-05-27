package com.AUTOMATIONPRACTICE.coreUtility;





	
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Random;

	import org.apache.poi.hpsf.Date;
	import org.openqa.selenium.WebElement;

	/**
	 * this class contains java specific resuable methods
	 * @author Roopa
	 *
	 */
	public class JavaUtility {
	  /**
	   * This method is used to convert string to long
	   * @param value
	   * @return
	   */
		public long stringToLong(String value)
		{
		    return Long.parseLong(value);

		 }
		
		
		/**
		 * This method is used to get random number
		 * @param limit
		 * @return 
		 */
		public int getRandomNumber(int limit)
		{
			Random random = new Random();
			return random.nextInt(limit);
		}

		
		
		public static void printStatement(String message)
		{
			System.out.println(message);
		}

		
		public static void assertionThroughIfCondition(String actualResult,String expectedResult,String testCaseName)
		{
			if(actualResult.equalsIgnoreCase(expectedResult))
			{
				System.out.println(testCaseName+"Created successfully");
				System.out.println("Tc pass");
			}
		}
		
		
		public static void customWait(WebElement ele,long polingTime,int duration) throws InterruptedException
		{
			int count=0;
			while(count<=duration)
			{
				try
				{
				      ele.click();
				      break;
			     }
				catch(Throwable e)
				{
					Thread.sleep(polingTime*1000);
					count++;
				}
			}
		}
		
		public String dateTimeInFormat()
		{
			 String dateTime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new java.util.Date());
			return dateTime;
		}


		
		
	






}
