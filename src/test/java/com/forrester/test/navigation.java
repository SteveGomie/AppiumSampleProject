package com.forrester.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


public class navigation 
{
AppiumDriver  driver;
private static AppiumDriverLocalService service;

@BeforeClass
public void setUp() throws InterruptedException, IOException
{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	 String currentpath = System.getProperty("user.dir");
	 System.out.println(currentpath);
	 File appDir = new File(currentpath+"/Apps");
     File app = new File(appDir, "app-QA-debug.apk");
       DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Google Nexus 6 - 5.0.0 - API 21 - 1440x2560");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		
       String osName = System.getProperty("os.name").toLowerCase();

        String nodePath = null;
        String appiumPath = null;

       if (osName.contains("mac")) {
     //     mac path
            nodePath = "/usr/local/bin/node";
            appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
        } else if (osName.contains("linux")) {
   /// linux path
            nodePath = System.getenv("HOME") + "/.linuxbrew/bin/node";
            appiumPath = System.getenv("HOME") + "/.linuxbrew/lib/node_modules/appium/build/lib/main.js";
        }
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodePath))
                .usingPort(4723)
                .withAppiumJS(new File(appiumPath)));
        service.start();
    	//Runtime.getRuntime().exec("/Users/stevangomes/Documents/todaytest/forresterproject/src/test/resources/startappium.sh");*/
        Thread.sleep(7000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		Thread.sleep(7000);
}
@Test
public void action() throws Exception 
{
    driver.findElement(By.id("com.kumandgo.rewards:id/welcomeSignIn")).click();
    Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text='Email Address']")).sendKeys("sgomes@mobiquityinc.com");
	//driver.hideKeyboard();
	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.EditText[1]")).click();
	//driver.hideKeyboard();
	driver.getKeyboard().sendKeys("Steve@123#");
	driver.hideKeyboard();
	driver.findElement(By.id("com.kumandgo.rewards:id/sign_in")).click();
	Thread.sleep(10000);
   
}
@AfterClass
public void teardown()
{
	service.stop();
	
}
}

