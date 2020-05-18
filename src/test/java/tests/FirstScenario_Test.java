package tests;

import core.Driver;
import core.PropertiesLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.enums.MenuItem;
import web.pages.StartPage;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class FirstScenario_Test {

  @BeforeClass
  public void setUp() {
    Driver.getDriver().get(PropertiesLoader.getProperty("baseUrl"));
  }

  @Test
  public void checkStartPage() {
    StartPage startPage = new StartPage();
    SoftAssert assertion = new SoftAssert();
    for (MenuItem menuItem : MenuItem.values()) {
      boolean isMenuItemHeaderStartPageDisplayed = startPage.isMenuItemHeaderDisplayed(menuItem);
      assertion.assertTrue(isMenuItemHeaderStartPageDisplayed, String.format("Menu item \"%s\" is not displayed in Header.",
          menuItem.getTitle()));
    }
    assertion.assertAll();
  }

  @AfterClass
  public void tearDown() {
    Driver.stopDriver(Driver.getCurrentDriver());
  }
}
