package web.blocks.searchResultsPage;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class SearchSnippetsBlock extends BasePage {

  public SearchSnippetsBlock() {
    super();
  }

  public SearchSnippetsBlock(By container) {
    super(container);
  }

  public boolean isPackageDisplayed(String packageName) {
    log.info(String.format("Checking if the package \"%s\" is displayed on the current page.", packageName));
    return getSearchSnippetItems().stream()
        .anyMatch(searchSnippetItem -> searchSnippetItem.getPackageName().equals(packageName));
  }

  public SearchSnippetsBlock openPackage(String packageName) {
    log.info(String.format("Click on the package \"%s\".", packageName));
    getSearchSnippetItem(packageName).openPackage();
    return this;
  }

  private SearchSnippetItem getSearchSnippetItem(String packageName) {
    log.info(String.format("Get package \"%s\" on the current page.", packageName));
    return getSearchSnippetItems().stream()
        .filter(searchSnippetItem -> searchSnippetItem.getPackageName().equals(packageName))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(String.format("Package \"%s\" not found.", packageName)));
  }

  private List<SearchSnippetItem> getSearchSnippetItems() {
    log.info("Get all packages on the current page.");
    List<SearchSnippetItem> searchSnippetItems = getSearchContext().findElements(SearchSnippetItem.SEARCH_SNIPPET_ITEM)
        .stream()
        .map(SearchSnippetItem::new)
        .collect(Collectors.toList());
    if (searchSnippetItems.size() == 0)
      throw new RuntimeException("No packages found.");
    return searchSnippetItems;
  }

  private static class SearchSnippetItem extends BasePage {

    private static final By SEARCH_SNIPPET_ITEM = new ByLocator("//div[@class='SearchSnippet']", false);
    private static final By PACKAGE_NAME = new ByLocator("//h2", false);

    private WebElement searchSnippetItem;

    private SearchSnippetItem(SearchContext context) {
      super(context);
      searchSnippetItem = (WebElement) context;
    }

    private String getPackageName() {
      log.info("Getting package title.");
      return searchSnippetItem.findElement(PACKAGE_NAME).getText();
    }

    private void openPackage() {
      log.info("Click on the package title.");
      searchSnippetItem.findElement(PACKAGE_NAME).click();
    }
  }
}

