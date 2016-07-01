package com.testframeworkdemo.framework.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverHelper extends EventFiringWebDriver {
    private static final Logger LOG = LoggerFactory.getLogger(WebDriverHelper.class);
    private static RemoteWebDriver SHARED_DRIVER = null;
    private static final Thread CLOSE_THREAD = new Thread() {

        @Override
        public void run() {
        	SHARED_DRIVER.quit();
        }
    };
    
    private static String BROWSER = "chrome";
    private static String PLATFORM = "linux";
    private static String DRIVER_ROOT_DIR = "/home/erik/DEV/git/java/TestFramework-Java/tools/chromedriver/linux64/chromedriver";
    private static String SELENIUM_HOST = null;
    private static String SELENIUM_PORT;
    private static String SELENIUM_REMOTE_URL;
    private static Dimension BROWSER_WINDOW_SIZE;
    private static Integer BROWSER_WINDOW_WIDTH;
    private static Integer BROWSER_WINDOW_HEIGHT;

    static {
////        Props.loadRunConfigProps("/environment.properties");
//        SELENIUM_HOST = Props.getProp("driverhost");
//        SELENIUM_PORT = Props.getProp("driverport");
//        PLATFORM = Props.getProp("platform");
//        BROWSER = Props.getProp("browser");
//        BROWSER_WINDOW_WIDTH = Integer.parseInt(Props.getProp("browser.width"));
//        BROWSER_WINDOW_HEIGHT = Integer.parseInt(Props.getProp("browser.height"));
//        BROWSER_WINDOW_SIZE = new Dimension(BROWSER_WINDOW_WIDTH, BROWSER_WINDOW_HEIGHT);
//        DRIVER_ROOT_DIR = Props.getProp(
//                "driver.root.dir");

//        if (!DRIVER_ROOT_DIR.equals("DEFAULT_PATH")) {
//            System.setProperty("webdriver.chrome.driver", getDriverPath());
//            System.setProperty("webdriver.ie.driver", getDriverPath());
//            System.setProperty("phantomjs.binary.path", getDriverPath());
//        }

        try {
            switch (BROWSER.toLowerCase()) {
                case ("chrome"):
                    startChromeDriver();
                    break;
                case ("firefox"):
                    startFireFoxDriver();
                    break;
                case ("iexplore"):
                    startIEDriver();
                    break;
                case ("phantomjs"):
                    startPhantomJsDriver();
                    break;
                case ("sauce"):
                    startSauceDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser " + BROWSER + " or Platform "
                            + PLATFORM + " type not supported");
            }

        } catch (IllegalStateException e) {
            LOG.error("FIX path for driver.root.dir in pom.xml " + DRIVER_ROOT_DIR
                    + " Browser parameter " + BROWSER + " Platform parameter " + PLATFORM
                    + " type not supported");
        }
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public WebDriverHelper() {
        super(SHARED_DRIVER);
    }

//    private static String getDriverPath() {
//        DRIVER_PATH = Props.getProp("driver.root.dir");
//        return DRIVER_PATH;
//    }

    private static void startIEDriver() {
        DesiredCapabilities capabilities = getInternetExploreDesiredCapabilities();
        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty())
        	SHARED_DRIVER = new InternetExplorerDriver(capabilities);
        else {
            try {
            	SHARED_DRIVER = getRemoteWebDriver(capabilities);
            } catch (MalformedURLException e) {
                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
            }
        }
        SHARED_DRIVER.manage().window();
        //.setSize(BROWSER_WINDOW_SIZE);
    }

    private static void startFireFoxDriver() {
        DesiredCapabilities capabilities = getFireFoxDesiredCapabilities();
        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty())
        	SHARED_DRIVER = new FirefoxDriver();
        else {
            try {
            	SHARED_DRIVER = getRemoteWebDriver(capabilities);
            } catch (MalformedURLException e) {
                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
            }
        }
        SHARED_DRIVER.manage().window();
        //.setSize(BROWSER_WINDOW_SIZE);
    }

    private static void startPhantomJsDriver() {
        DesiredCapabilities capabilities = getPhantomJsCapabilities();
        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty())
        	SHARED_DRIVER = new PhantomJSDriver(capabilities);
        else {
            try {
            	SHARED_DRIVER = getRemoteWebDriver(capabilities);
            } catch (MalformedURLException e) {
                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
            }
        }
        SHARED_DRIVER.manage().window();
        //.setSize(BROWSER_WINDOW_SIZE);
    }

    private static void startSauceDriver() {
        DesiredCapabilities capabilities = getSauceCapabilities();
        try {
        	SHARED_DRIVER = new RemoteWebDriver(new URL("http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOG.error(" Error Sauce Url " + e.getMessage());
        }
    }

    private static WebDriver startChromeDriver() {
        DesiredCapabilities capabilities = getChromeDesiredCapabilities();

        if (SELENIUM_HOST == null || SELENIUM_HOST.isEmpty())
        	SHARED_DRIVER = new ChromeDriver(
                    ChromeDriverService.createDefaultService(), capabilities);
        else {
            try {
            	SHARED_DRIVER = getRemoteWebDriver(capabilities);
            } catch (MalformedURLException e) {
                LOG.error(SELENIUM_REMOTE_URL + " Error " + e.getMessage());
            }
        }
        SHARED_DRIVER.manage().window();
        //.setSize(BROWSER_WINDOW_SIZE);
        return SHARED_DRIVER;
    }

    private static DesiredCapabilities getChromeDesiredCapabilities() {

        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.OFF);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--test-type");
        capabilities.setCapability("chrome.verbose", false);

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

    private static DesiredCapabilities getFireFoxDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setBrowserName("firefox");

        capabilities.setCapability("disable-restore-session-state", true);
        return capabilities;

    }

    private static DesiredCapabilities getInternetExploreDesiredCapabilities() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.OFF);
        DesiredCapabilities capabilities = DesiredCapabilities
                .internetExplorer();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        capabilities
                .setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);
        capabilities.setVersion("9");
        return capabilities;
    }

    private static DesiredCapabilities getPhantomJsCapabilities() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.OFF);
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
//        capabilities
//                .setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getDriverPath());
        return capabilities;
    }

    private static DesiredCapabilities getSauceCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", BROWSER);
        capabilities.setCapability("platform", PLATFORM);
        capabilities.setCapability("sauce-advisor", false);
        capabilities.setCapability("record-video", false);
        capabilities.setCapability("record-screenshots", false);
        return capabilities;
    }

    private static RemoteWebDriver getRemoteWebDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        SELENIUM_REMOTE_URL = "http://" + SELENIUM_HOST + ":" + SELENIUM_PORT + "/wd/hub";
        LOG.info(SELENIUM_REMOTE_URL + " Checking Selenium Remote URL");
        return new RemoteWebDriver(new URL(SELENIUM_REMOTE_URL), (capabilities));
    }

    public static WebDriver getSharedDriver() {
        return SHARED_DRIVER;
    }

    public static void resizeBrowserWindow(Dimension dimension) {
    	getSharedDriver().manage().window().setSize(dimension);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
}
