package web.blocks.packagePage;

import core.ByLocator;
import core.BasePage;
import org.openqa.selenium.By;

/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public class PackageInfoBlock extends BasePage {

  private static final By VERSION = new ByLocator("//div[@class='DetailsHeader-version']", false);
  private static final By PUBLISHED = new ByLocator("//span[text()='Published:']/following-sibling::strong", false);
  private static final By MODULE = new ByLocator("//span[text()='Module: ']/following-sibling::span", false);

  public PackageInfoBlock() {
    super();
  }

  public PackageInfoBlock(By container) {
    super(container);
  }

  public String getVersion() {
    log.info("Getting value of the element \"Version\".");
    return getSearchContext().findElement(VERSION).getText();
  }

  public String getPublishedDate() {
    log.info("Getting value of the element \"Published\".");
    return getSearchContext().findElement(PUBLISHED).getText();
  }

  public String getModule() {
    log.info("Getting value of the element \"Module\".");
    return getSearchContext().findElement(MODULE).getText();
  }
}

