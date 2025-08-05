public class Students implements Comparable {
  private String name;
  private String name1;
  private String name2;

  public Students(String name, String name1, String name2) {
    this.name = name;
    this.name1 = name1;
    this.name2 = name2;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName1() {
    return name1;
  }

  public void setName1(String name1) {
    this.name1 = name1;
  }

  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  @Override
  public String toString() {
    return "Students{" + "name='" + name + '\'' + ", name1='" + name1 + '\'' + ", name2='" + name2 + '\'' + '}';
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
