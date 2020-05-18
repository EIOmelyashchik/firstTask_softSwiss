package core;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * User: E.Omelyashchik
 * Date: 16.05.20
 */
public class ByLocator extends By {

  private String xpath;

  public ByLocator(String xpath, boolean isGlobal) {
    if (isGlobal) {
      this.xpath = xpath;
    } else {
      this.xpath = xpath.replaceFirst("//", ".//");
    }
  }

  @Override
  public List<WebElement> findElements(SearchContext context) {
    return context.findElements(new ByXPath(xpath));
  }

}
