package web.enums;


/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public enum TabPackageItem {

  DOC("Doc"),
  OVERVIEW("Overview"),
  SUBDIRECTORIES("Subdirectories"),
  VERSIONS("Versions"),
  IMPORTS("Imports"),
  IMPORTED_BY("Imported By"),
  LICENSES("Licenses");

  private String title;

  private TabPackageItem(String title) {
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
