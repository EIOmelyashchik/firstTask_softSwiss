package core;


import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * User: E.Omelyashchik
 * Date: 16.05.20
 */
public class CapabilitiesFactory {


  public static DesiredCapabilities createCapabilities(Browser browser) {
    DesiredCapabilities desiredCapabilities;
    switch (browser) {
      case FIREFOX:
        desiredCapabilities = DesiredCapabilities.firefox();
        break;
      case IE10:
        desiredCapabilities = DesiredCapabilities.internetExplorer();
        break;
      default:
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        break;
    }
    desiredCapabilities.setBrowserName(PropertiesLoader.getProperty("browser").toLowerCase());
    desiredCapabilities.setVersion(PropertiesLoader.getProperty("browser_version"));
    desiredCapabilities.setCapability("enableVNC", true);
    desiredCapabilities.setPlatform(getCurrentPlatform());
    return desiredCapabilities;
  }

  private static Platform getCurrentPlatform() {
    switch (PropertiesLoader.getProperty("platform")) {
      case "windows":
        return Platform.WINDOWS;
      case "mac":
        return Platform.MAC;
      default:
        return Platform.LINUX;
    }
  }
}
