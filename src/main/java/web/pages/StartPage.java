package web.pages;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;
import web.blocks.HeaderBlock;
import web.enums.MenuItem;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class StartPage extends BasePage {

  private static final By HEADER_CONTAINER = new ByLocator("//div[contains(@class,'Header')]", true);

  private HeaderBlock headerBlock;

  public StartPage() {
    super();
    headerBlock = new HeaderBlock(HEADER_CONTAINER);
  }

  public boolean isMenuItemHeaderDisplayed(MenuItem menuItem) {
    return headerBlock.isMenuItemDisplayed(menuItem);
  }

  public SearchResultsPage searchPackageHeader(String text) {
    headerBlock.typeSearchInput(text)
        .clickSearchButton();
    return new SearchResultsPage();
  }
}

