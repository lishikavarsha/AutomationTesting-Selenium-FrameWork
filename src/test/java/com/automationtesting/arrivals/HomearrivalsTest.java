package com.automationtesting.arrivals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.AUTOMATIONPRACTICE.coreUtility.FileUtility;
import com.AUTOMATIONPRACTICE.coreUtility.IConstantPath;
import com.AUTOMATIONPRACTICE.coreUtility.JavaUtility;
import com.AUTOMATIONPRACTICE.coreUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomearrivalsTest {

	public static void main(String[] args) throws IOException {
		JavaUtility jutil = new JavaUtility();
		FileUtility.openPropertyFile(IConstantPath.PROPERTYFILE_PATH);
		
	    String url = FileUtility.getDataFromPropertyFile("url");
		String browsername = FileUtility.getDataFromPropertyFile("browsername");
		WebDriver driver1=null;
		
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
		WebdriverUtility.navigateApp(url, driver1);
		driver1.findElement(By.xpath("//a[.='Test Cases']")).click();
	}
}
