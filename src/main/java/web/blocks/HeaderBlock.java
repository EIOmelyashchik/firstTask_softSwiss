package web.blocks;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;
import web.enums.MenuItem;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class HeaderBlock extends BasePage {

  private static final By SEARCH_INPUT = new ByLocator("//input[contains(@class,'SearchForm')]", false);
  private static final By SEARCH_BUTTON = new ByLocator("//button[contains(@class,'SearchForm')]", false);

  private static final String MENU_ITEM_PATTERN = "//a[text()='%s']";

  public HeaderBlock() {
    super();
  }

  public HeaderBlock(By container) {
    super(container);
  }

  public boolean isMenuItemDisplayed(MenuItem menuItem) {
    log.info(String.format("Checking if the menu item \"%s\" is displayed", menuItem.getTitle()));
    By locator = new By.ByXPath(String.format(MENU_ITEM_PATTERN, menuItem.getTitle()));
    return isElementDisplayed(getSearchContext(), locator);
  }

  public HeaderBlock typeSearchInput(String text) {
    log.info(String.format("Enter the value \"%s\" in the search field.", text));
    getSearchContext().findElement(SEARCH_INPUT).sendKeys(text);
    return this;
  }

  public HeaderBlock clickSearchButton() {
    log.info("Click on the search button.");
    getSearchContext().findElement(SEARCH_BUTTON).click();
    return this;
  }
}

