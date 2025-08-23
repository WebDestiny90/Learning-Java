public class Hobby {
  private String name;
  private int minimumAge;

  public Hobby(String name, int minimumAge) {
    this.name = name;
    this.minimumAge = minimumAge;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMinimumAge() {
    return minimumAge;
  }

  public void setMinimumAge(int minimumAge) {
    this.minimumAge = minimumAge;
  }

  @Override
  public String toString() {
    return "Hobby{" + "name='" + name + '\'' + ", minimumAge=" + minimumAge + '}';
  }
}
