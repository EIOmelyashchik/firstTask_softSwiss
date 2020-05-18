package web.pages;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;
import web.blocks.packagePage.PackageInfoBlock;
import web.blocks.packagePage.TabsPackageBlock;
import web.enums.TabPackageItem;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class PackagePage extends BasePage {

  private static final By PACKAGE_INFO_CONTAINER = new ByLocator("//header[@class='DetailsHeader']", true);
  private static final By TABS_CONTAINER = new ByLocator("//ul[@class='DetailsNav-list']", true);

  private PackageInfoBlock packageInfoBlock;
  private TabsPackageBlock tabsPackageBlock;

  public PackagePage() {
    super();
    packageInfoBlock = new PackageInfoBlock(PACKAGE_INFO_CONTAINER);
    tabsPackageBlock = new TabsPackageBlock(TABS_CONTAINER);
  }

  public boolean isTabDisplayed(TabPackageItem tab) {
    return tabsPackageBlock.isTabDisplayed(tab);
  }

  public String getVersion() {
    return packageInfoBlock.getVersion();
  }

  public String getPublishedDate() {
    return packageInfoBlock.getPublishedDate();
  }

  public String getModule() {
    return packageInfoBlock.getModule();
  }
}

