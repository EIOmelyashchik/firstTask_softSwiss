package web.enums;


/**
 * User: E.Omelyashchik
 * Date: 17.05.20
 */
public enum PackageInfo {

  ONE("github.com/mikekonan/protoc-gen-setter", "v1.3.2", "Apr 13, 2020");

  private String name;
  private String version;
  private String publishedDate;

  PackageInfo(String name, String version, String publishedDate) {
    this.name = name;
    this.version = version;
    this.publishedDate = publishedDate;
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  public String getPublishedDate() {
    return publishedDate;
  }

  @Override
  public String toString() {
    return name;
  }
}
