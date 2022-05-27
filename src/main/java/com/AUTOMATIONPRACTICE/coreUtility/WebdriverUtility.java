package com.AUTOMATIONPRACTICE.coreUtility;





	
	import java.io.File;
	import java.io.IOException;
	import java.util.Date;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;
	import com.google.protobuf.ByteString.Output;

	import io.github.bonigarcia.wdm.WebDriverManager;

	/**
	 * This class is used to maintain all webdriver actions
	 * @author Roopa
	 *
	 */
	public class WebdriverUtility {
	
		static WebDriverWait wait;
		static WebDriver driver1;
		static Select dropdown;
		static Actions act;
		static JavascriptExecutor js;
		static JavaUtility jutil = new JavaUtility();
		
		public static void intailizeBrowser(String browsername )
		{
			switch(browsername)
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver1=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver1=new FirefoxDriver();
				break;
			default:
				System.out.println("Please specify proper browser key");
				WebDriverManager.chromedriver().setup();
				driver1=new ChromeDriver();
				break;
			}

		}



		/**
		 * This driver is used 
		 * @return
		 */
		public static WebDriver getDriver()
		{
			return driver1;
		}




		/**
		 * This method is used to navigate the application
		 * @param url
		 * @param driver1
		 */
		public static void navigateApp(String url,WebDriver driver1)
		{
			driver1.get(url);
		}



		/**
		 * This method is used to maximize the browser and implicitly wait
		 * @param longtimeout
		 * @param driver1
		 */
		public static void browserSetting(long longtimeout,WebDriver driver1)
		{
			maximizeBrowser(driver1);
			waitTillPageLoad(longtimeout,driver1);

		}



		/**
		 * This method is used to maximize the browser
		 */
		public static void maximizeBrowser(WebDriver driver1)
		{
			driver1.manage().window().maximize();
		}



		/**
		 * 
		 * @param longtimeout
		 */

		public static void waitTillPageLoad(long longtimeout,WebDriver driver1)
		{
			driver1.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		}


		/**
		 * This method is use to perform mouse hover  action on the element
		 * @param ele
		 */
		public static void mouseHoverOnTheElement(WebElement ele,WebDriver driver1)
		{
			Actions act=new Actions(driver1);
			act.moveToElement(ele).perform();

		}




		/**
		 * This method is used to quit the browser 
		 * @param driver
		 */
		public static void quitbrowser(WebDriver driver1)
		{
			driver1.quit();
		}




		/**
		 * This method is used to wait the control till particular element to be clicked
		 * @param ele
		 */
		public static void waitUntillElementClickable(WebElement ele)
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}


		/**
		 * 
		 * @param ele
		 */
		public static void waitUtillElementVisible(WebElement ele)
		{

			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}



		/**
		 * This method is used to initialize wait
		 * @param timeout
		 * @param driver1
		 */
		public static void explicitlyWait(long timeout,WebDriver driver1)
		{
			wait = new WebDriverWait(driver1, timeout);

		}





		/**
		 * This method is used to switch the control from one window to another based on title
		 * @param driver
		 * @param partialText
		 */
		public static void switchToWindow(WebDriver driver1,String partialText)
		{
			Set<String> windowsid = driver1.getWindowHandles();
			for(String id:windowsid)
			{
				driver1.switchTo().window(id);
				if(driver1.getTitle().contains(partialText))
				{
					break;
				}
			}
		}
		/**
		 * This method is used to select dropdown By value
		 * @param ele
		 * @param text
		 */
		public static void selectDropDown(WebElement element,String value)
		{
			dropdown=new Select(element);
			dropdown.selectByValue(value);	
		}

		/**
		 * This method is used to select dropdown By Visible Text
		 * @param ele
		 * @param text
		 */
		public static void selectDropDown(String visibleText,WebElement element)
		{
			dropdown=new Select(element);
			dropdown.selectByVisibleText( visibleText);	
		}


		/**
		 * This method is used to select the dropdown by using index
		 * @param ele
		 * @param text
		 */
		public static void selectDropDown(WebElement ele,int index)
		{
			dropdown=new Select(ele);
			dropdown.selectByIndex(index);	
		}



		/**
		 * 
		 * @param driver1
		 */
		public static void initializeActions(WebDriver driver1)
		{
			act = new Actions(driver1);
		}


		/**
		 * 
		 * @param element
		 */
		public static void mouseHoverOntheElement(WebElement element)
		{
			act.moveToElement(element).perform();
		}


		/**
		 * 
		 * @param element
		 */
		public static void doubleClick(WebElement element)
		{
			act.doubleClick().perform();
		}



		/**
		 * This method is used to switch the frame by index
		 * @param driver1
		 * @param index
		 */
		public static void switchToFrame(WebDriver driver1,int index)
		{
			driver1.switchTo().frame(index);
		}

		/**
		 * This methos is used to switch the frame by name
		 * @param driver1
		 * @param name
		 */
		public static void switchToFrame(WebDriver driver1,String name)
		{
			driver1.switchTo().frame(name);
		}

		/**
		 * this method used to switch the frame by name or Id
		 * @param driver1
		 * @param nameorId
		 */
		public static void switchToFrame(WebDriver driver1,WebElement nameorId)
		{
			driver1.switchTo().frame(nameorId);
		}


		/**
		 * This method is used to switch back to the home page
		 * @param element
		 */
		public static void switchBackToHomePage(WebDriver driver1)
		{
			driver1.switchTo().defaultContent();
		}


		public static void initailzeJs(WebDriver driver1)
		{
			js = (JavascriptExecutor)driver1;
		}


		public static void enterDataThroughJs(WebElement ele,String data)
		{

			js.executeScript("arguments[0].value=arguments[1]",ele,data);
		}

		public static void navigateApplicationThroughJs(String url)
		{

			js.executeScript("window.location=arguments[0]",url);

		}

		public static void clickThroughJs(WebElement element)
		{

			js.executeScript("arguments[0].click()",element);

		}

		public static void scrolltospecificfieldHeight(String height)
		{

			js.executeScript("windsow.scrollBy(0,"+height+")");
		}


		public static void scrollToBottom( )
		{

			js.executeScript("windsow.scrollBy(0,document.body.scrollHieght)");
		}

		public static void scrollTillElemet(WebElement element)
		{

			js.executeScript("arguments[0].scrollIntoView()",element);
		}


		public static void alertAccept(WebDriver driver1)
		{
			driver1.switchTo().alert().accept();
		}
		

		public static void alertDismiss(WebDriver driver1)
		{
			driver1.switchTo().alert().dismiss();
		}
		

		public static void alertsendData(WebDriver driver1,String text)
		{
			driver1.switchTo().alert().sendKeys(text);
		}
		

		public static String getalertText(WebDriver driver1)
		{
			return driver1.switchTo().alert().getText();
		}
		

		public static void rightclick(WebElement element)
		{
			act.contextClick(element).perform();
		}
		
		
		
		public static String takesScreenshot(String fileName,WebDriver driver1) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver1;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File("./screenshot/"+fileName+"_"+jutil.dateTimeInFormat()+".png");
			//System.out.println(dst.getAbsolutePath());
			Files.copy(src, dst);
			return dst.getAbsolutePath();
		}



		
		



}
