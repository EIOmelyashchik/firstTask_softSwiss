package core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * User: E.Omelyashchik
 * Date: 16.05.20
 */
public class Driver extends RemoteWebDriver implements SearchContext {

  private static ThreadLocal<Driver> driverStorage = new ThreadLocal<>();
  private final static int TIMEOUT = 10;

  private Driver(URL urlRemoteServer, Capabilities capabilities) {
    super(urlRemoteServer, capabilities);
    manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    driverStorage.set(this);
  }

  /**
   * Creating a driver for current thread and placing it in the ThreadLocal repository
   *
   * @param browser Browser
   * @return driver object
   */
  private static Driver getDriver(Browser browser) {
    Driver driver;
    if ((driver = driverStorage.get()) == null) {
      try {
        driver = new Driver(new URL(PropertiesLoader.getProperty("server")),
            CapabilitiesFactory.createCapabilities(browser));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    return driver;
  }

  public static Driver getDriver() {
    switch (PropertiesLoader.getProperty("browser")) {
      case "FIREFOX":
        return getDriver(Browser.FIREFOX);
      case "IE10":
        return getDriver(Browser.IE10);
      default:
        return getDriver(Browser.CHROME);
    }
  }

  /**
   * Returns a driver from ThreadLocal storage for current thread
   *
   * @return driver for current thread
   */
  public static Driver getCurrentDriver() {
    return driverStorage.get();
  }

  /**
   * Stops the driver for current thread, cleans storage
   *
   * @param driver driver for current thread
   */
  public static void stopDriver(Driver driver) {
    if (driver != null) {
      driverStorage.remove();
      driver.quit();
    }
  }
}



