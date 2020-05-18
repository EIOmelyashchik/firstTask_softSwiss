package tests;

import core.Driver;
import core.PropertiesLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.enums.PackageInfo;
import web.enums.TabPackageItem;
import web.pages.PackagePage;
import web.pages.StartPage;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class SecondScenario_Test {


  @BeforeClass
  public void setUp() {
    Driver.getDriver().get(PropertiesLoader.getProperty("baseUrl"));
  }

  @Test
  public void checkPackagePage() {
    String packageName = PackageInfo.ONE.getName();
    PackagePage packagePage = new StartPage()
        .searchPackageHeader("setter")
        .goToRequiredPackage(packageName)
        .openRequiredPackage(packageName);
    SoftAssert assertion = new SoftAssert();
    for (TabPackageItem tab : TabPackageItem.values()) {
      boolean isTabPackagePageDisplayed = packagePage.isTabDisplayed(tab);
      assertion.assertTrue(isTabPackagePageDisplayed, String.format("Tab \"%s\" is not displayed.", tab.getTitle()));
    }
    String versionPackagePage = packagePage.getVersion();
    String publishedDatePackagePage = packagePage.getPublishedDate();
    String modulePackagePage = packagePage.getModule();
    assertion.assertEquals(versionPackagePage, PackageInfo.ONE.getVersion(), "Value \"Version\" is not correct.");
    assertion.assertEquals(publishedDatePackagePage, PackageInfo.ONE.getPublishedDate(), "Value \"Published\" is not correct.");
    assertion.assertEquals(modulePackagePage, packageName, "Value \"Module\" is not correct.");
    assertion.assertAll();
  }

  @AfterClass
  public void tearDown() {
    Driver.stopDriver(Driver.getCurrentDriver());
  }
}
