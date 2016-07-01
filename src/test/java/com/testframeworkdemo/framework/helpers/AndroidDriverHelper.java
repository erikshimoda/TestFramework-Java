package com.testframeworkdemo.framework.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidDriverHelper extends EventFiringWebDriver {
	private static final Logger LOG = LoggerFactory.getLogger(AndroidDriverHelper.class);
	// private static final String RUN_CONFIG_PROPERTIES =
	// "/environment.properties";

	private static AppiumDriver<WebElement> SHARED_ANDROID_DRIVER = null;

	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			SHARED_ANDROID_DRIVER.quit();
		}
	};

	static {
		// Props.loadRunConfigProps(RUN_CONFIG_PROPERTIES);
		SHARED_ANDROID_DRIVER = startAppiumDriver();
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	public AndroidDriverHelper() {
		super(SHARED_ANDROID_DRIVER);
	}

	private static AppiumDriver<WebElement> startAppiumDriver() {
		DesiredCapabilities capabilities = getAppiumDesiredCapabilities();
		try {
			SHARED_ANDROID_DRIVER = new AndroidDriver<>(new URL(
					"http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return SHARED_ANDROID_DRIVER;
	}

	private static DesiredCapabilities getAppiumDesiredCapabilities() {
		File appDir = new File(
				"/home/erik/DEV/git/java/TestFramework-Java/apps");
		File app = new File(appDir, "Testedoqi.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.brazilcats.testedoqi");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				"Appium");

		capabilities.setCapability(MobileCapabilityType.APP,
				app.getAbsolutePath());
		// capabilities.setCapability("deviceName", "42f7ab1fb7b59fab");
		return capabilities;
	}

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
	
	public static AppiumDriver<WebElement> getSharedAndroidDriver() {
		return SHARED_ANDROID_DRIVER;
	}
}
