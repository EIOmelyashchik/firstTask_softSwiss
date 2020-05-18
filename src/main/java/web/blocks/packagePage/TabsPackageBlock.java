package web.blocks.packagePage;

import core.BasePage;
import org.openqa.selenium.By;
import web.enums.TabPackageItem;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class TabsPackageBlock extends BasePage {

  private static final String MENU_ITEM_PATTERN = "//a[contains(text(),'%s')]";

  public TabsPackageBlock() {
    super();
  }

  public TabsPackageBlock(By container) {
    super(container);
  }

  public boolean isTabDisplayed(TabPackageItem tab) {
    log.info(String.format("Checking if the tab \"%s\" is displayed", tab.getTitle()));
    By locator = new By.ByXPath(String.format(MENU_ITEM_PATTERN, tab.getTitle()));
    return isElementDisplayed(getSearchContext(), locator);
  }
}

