package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * User: E.Omelyashchik
 * Date: 16.05.20
 */
public class PropertiesLoader {

  private final static String PROPERTIES_PATH = "./src/main/resources/config.properties";

  private static Properties properties;

  private static Logger log = LogManager.getLogger();

  static {
    properties = new Properties();
    loadFromConfig(properties);
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }


  private static void loadFromConfig(Properties properties) {
    try {
      log.info(String.format("Loading properties from \"%s\".", PROPERTIES_PATH));
      properties.load(new FileReader(PROPERTIES_PATH));
    } catch (IOException exc) {
      log.error(String.format("Loading properties from \"%s\" failed.", PROPERTIES_PATH));
      throw new RuntimeException(exc.getMessage());
    }
  }
}

