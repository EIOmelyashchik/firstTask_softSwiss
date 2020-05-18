package core;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import java.util.concurrent.TimeUnit;


/**
 * User: E.Omelyashchik
 * Date: 16.05.20
 */
public class BasePage {

  private SearchContext searchContext;

  protected Logger log = LogManager.getLogger();

  /**
   * When the search context is the driver itself
   */
  public BasePage() {
    this.searchContext = Driver.getCurrentDriver();
  }

  /**
   * When the search context is a web element
   *
   * @param searchContextLocator Locator defines the context
   */
  public BasePage(By searchContextLocator) {
    Preconditions.checkNotNull(searchContextLocator, "Search context cannot be equal null.");
    this.searchContext = Driver.getCurrentDriver().findElement(searchContextLocator);
  }

  /**
   * When the search context is a web element
   *
   * @param searchContext Search context
   */
  public BasePage(SearchContext searchContext) {
    Preconditions.checkNotNull(searchContext, "Дочерний контекст поиска не может быть равен null.");
    this.searchContext = searchContext;
  }

  /**
   * @return Current search context
   */
  public SearchContext getSearchContext() {
    Preconditions.checkNotNull(searchContext, "Search context cannot be equal null.");
    return searchContext;
  }

  /**
   * Checks if an element is present and displayed in search context
   *
   * @param searchContext Search context
   * @param locator       Element locator
   * @return true if it's displayed, else false
   */
  public boolean isElementDisplayed(SearchContext searchContext, By locator) {
    return isPresent(searchContext, locator) && searchContext.findElement(locator).isDisplayed();
  }

  /**
   * Checks if an element is present in search context
   *
   * @param searchContext Search context
   * @param locator       Element locator
   * @return true if it's present, else false
   */
  public boolean isPresent(SearchContext searchContext, By locator) {
    changeImplicitlyTime(1);
    boolean isPresent = searchContext.findElements(locator).size() > 0;
    changeImplicitlyTime(10);
    return isPresent;
  }

  public void changeImplicitlyTime(int time) {
    Driver.getCurrentDriver()
        .manage()
        .timeouts()
        .implicitlyWait(time, TimeUnit.SECONDS);
  }
}