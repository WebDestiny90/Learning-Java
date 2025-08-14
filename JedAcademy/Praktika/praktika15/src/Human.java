import java.util.Objects;

public class Human {
  private String name;
  private String surName;

  public Human(String name, String surName) {
    this.name = name;
    this.surName = surName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Human human = (Human) o;
    return Objects.equals(name, human.name) && Objects.equals(surName, human.surName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surName);
  }

  @Override
  public String toString() {
    return "Human{" + "name='" + name + '\'' + ", surName='" + surName + '\'' + '}';
  }
}
