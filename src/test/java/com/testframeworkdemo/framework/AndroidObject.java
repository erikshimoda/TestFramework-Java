package com.testframeworkdemo.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.testframeworkdemo.framework.helpers.AndroidDriverHelper;

public abstract class AndroidObject {

	private static final Logger LOG = LoggerFactory.getLogger(AndroidObject.class);

	private static final long DRIVER_WAIT_TIME = 30;
	public static AppiumDriver<WebElement> androidDriver;

	public AndroidObject(AndroidDriverHelper androidDriver) {
		AndroidObject.androidDriver = AndroidDriverHelper.getSharedAndroidDriver();
	}

	public void swipe(int startx, int starty, int endx, int endy, int duration) {
		androidDriver.swipe(startx, starty, endx, endy, duration);
	}

	public static WebElement waitForVisibilityOf(final By by) {
		try {
			WebDriverWait wait = new WebDriverWait(androidDriver,
					DRIVER_WAIT_TIME);
			return wait
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException e) {
			LOG.info(e.getMessage());
			return null;
		}
	}

	public static WebElement waitForClickabilityOf(final By by) {
		try {
			WebDriverWait wait = new WebDriverWait(androidDriver,
					DRIVER_WAIT_TIME);
			return wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (TimeoutException e) {
			LOG.info(e.getMessage());
			return null;
		}
	}

	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", 0.50);
		swipeObject.put("startY", 0.95);
		swipeObject.put("endX", 0.50);
		swipeObject.put("endY", 0.01);
		swipeObject.put("duration", 3.0);
		js.executeScript("mobile: swipe", swipeObject);
	}

	public void swipeLeftToRight() {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", 0.01);
		swipeObject.put("startY", 0.5);
		swipeObject.put("endX", 0.9);
		swipeObject.put("endY", 0.6);
		swipeObject.put("duration", 3.0);
		js.executeScript("mobile: swipe", swipeObject);
	}

	public void swipeRightToLeft() {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", 0.9);
		swipeObject.put("startY", 0.5);
		swipeObject.put("endX", 0.01);
		swipeObject.put("endY", 0.5);
		swipeObject.put("duration", 3.0);
		js.executeScript("mobile: swipe", swipeObject);
	}

	public void swipeFirstCarouselFromRightToLeft() {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", 0.9);
		swipeObject.put("startY", 0.2);
		swipeObject.put("endX", 0.01);
		swipeObject.put("endY", 0.2);
		swipeObject.put("duration", 3.0);
		js.executeScript("mobile: swipe", swipeObject);
	}

	public void performTapAction(WebElement elementToTap) {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("x", (double) 360); // in pixels from left
		tapObject.put("y", (double) 170); // in pixels from top
		tapObject.put("element",
				Double.valueOf(((RemoteWebElement) elementToTap).getId()));
		js.executeScript("mobile: tap", tapObject);
	}
}