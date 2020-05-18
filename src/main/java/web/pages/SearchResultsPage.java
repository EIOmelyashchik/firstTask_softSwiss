package web.pages;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;
import web.blocks.searchResultsPage.PagesNavigationBlock;
import web.blocks.searchResultsPage.SearchSnippetsBlock;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class SearchResultsPage extends BasePage {

  private static final By PAGES_NAVIGATION_CONTAINER = new ByLocator("//div[@class='Pagination-nav']", true);
  private static final By SEARCH_SNIPPETS_CONTAINER = new ByLocator("//div[@class='SearchResults-resultCount']" +
      "/following-sibling::div", true);

  private PagesNavigationBlock pagesNavigationBlock;
  private SearchSnippetsBlock searchSnippetsBlock;

  public SearchResultsPage() {
    super();
    pagesNavigationBlock = new PagesNavigationBlock(PAGES_NAVIGATION_CONTAINER);
    searchSnippetsBlock = new SearchSnippetsBlock(SEARCH_SNIPPETS_CONTAINER);
  }

  private void reloadBlocks() {
    pagesNavigationBlock = new PagesNavigationBlock(PAGES_NAVIGATION_CONTAINER);
    searchSnippetsBlock = new SearchSnippetsBlock(SEARCH_SNIPPETS_CONTAINER);
  }

  public SearchResultsPage goToRequiredPackage(String packageName) {
    log.info(String.format("Looking for a package \"%s\".", packageName));
    if (searchSnippetsBlock.isPackageDisplayed(packageName))
      return this;
    while (pagesNavigationBlock.isNextDisplayed()) {
      pagesNavigationBlock.clickNext();
      reloadBlocks();
      if (searchSnippetsBlock.isPackageDisplayed(packageName))
        return this;
    }
    throw new RuntimeException(String.format("Package \"%s\" not found.", packageName));
  }

  public PackagePage openRequiredPackage(String packageName) {
    searchSnippetsBlock.openPackage(packageName);
    return new PackagePage();
  }
}

