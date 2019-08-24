package com.example.dialpadautomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NativeDialerApplicationAutomation {

    // This will show you Focused App in Your Emulator :
    // adb shell "dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'"

    AppiumDriver<MobileElement> appium_Driver;

    @BeforeTest
    public void settingEnvironment() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
            capabilities.setCapability("appPackage", "com.android.dialer");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        appium_Driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        appium_Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void CommencingTest(){

        try{

            //appium_Driver.back();
            appium_Driver.navigate().back();

        } catch (Exception ex){
            System.out.println(ex.getCause());
        }

        appium_Driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();

//        appium_Driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout" +
//                "/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout")).click();

        //appium_Driver.findElement(By.name("+")).click();
        //appium_Driver.findElementByAccessibilityId("+").click();
        //appium_Driver.findElementsById("com.android.dialer:id/dialpad_key_letters").get(8).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/digits")).sendKeys("+");
        //appium_Driver.findElementsById("com.android.dialer:id/dialpad_key_number").get(10).click();
//        111

        //appium_Driver.findElement(MobileBy.ByAndroidUIAutomator("new UiSelector().text(\"+\")"));
        //appium_Driver.findElement(MobileBy.ByAndroidUIAutomator("new UiSelector().className("android.widget.TextView").text(+)")).click();
        //appium_Driver.findElement(MobileBy.ByAndroidUIAutomator("new UiSelector().text(( "+" ))")).click();
        //appium_Driver.findElement(ByElementText("text value"))
        //appium_Driver.findElement(By.tagName("+")).click();
//        String selector = "new UiSelector().text(“+”))";
//        appium_Driver.findElement(MobileBy.AndroidUIAutomator(selector)).click();

        //TouchActions longClick = new TouchActions(appium_Driver);
        TouchAction longClick = new TouchAction(appium_Driver);
        //longClick.longPress(appium_Driver.findElementById("com.android.dialer:id/zero")).perform();
        //MobileElement mobileElement = appium_Driver.findElement(MobileBy.id("com.android.dialer:id/zero"));
        MobileElement mobileElement = appium_Driver.findElementById("com.android.dialer:id/zero");
        //longClick.longPress(mobileElement).release().perform();
        longClick.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(mobileElement))).release().perform();

        appium_Driver.findElement(By.xpath("//android.widget.TextView[@text='+']")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/eight")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/eight")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/zero")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/one")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/nine")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/one")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/five")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/six")).click();

        appium_Driver.findElement(By.id("com.android.dialer:id/four")).click();

        //appium_Driver.findElement(By.id("com.android.dialer:id/dialpad_key_number")).click();

        //appium_Driver.findElement(By.id("com.android.dialer:id/dialpad")).click();
        appium_Driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();

        appium_Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //appium_Driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
        appium_Driver.findElement(By.id("com.android.dialer:id/endButton")).click();

        appium_Driver.closeApp();


    }

    @AfterTest
    public void tearDown(){
        appium_Driver.quit();
        System.out.print("Test Completed");
    }


}
