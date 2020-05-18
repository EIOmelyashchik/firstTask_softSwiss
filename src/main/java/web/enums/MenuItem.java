package web.enums;


/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public enum MenuItem {

  WHY_GO("Why Go"),
  GETTING_STARTED("Getting Started"),
  DISCOVER_PACKAGES("Discover Packages"),
  ABOUT("About");

  private String title;

  private MenuItem(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return title;
  }
}
