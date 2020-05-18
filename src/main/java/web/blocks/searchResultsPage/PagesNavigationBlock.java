package web.blocks.searchResultsPage;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class PagesNavigationBlock extends BasePage {

  private static final By NEXT = new ByLocator("//a[contains(@class,'Pagination-next')]", false);

  public PagesNavigationBlock() {
    super();
  }

  public PagesNavigationBlock(By container) {
    super(container);
  }

  public PagesNavigationBlock clickNext() {
    log.info("Click on the \"Next\" button.");
    getSearchContext().findElement(NEXT).click();
    return this;
  }

  public boolean isNextDisplayed() {
    log.info("Checking if the element \"Next\" is displayed");
    return isElementDisplayed(getSearchContext(), NEXT);
  }
}

