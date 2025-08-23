import java.util.List;

public class Human {
  private String name;
  private int age;
  private List<Hobby> humanHobbys;

  public Human(String name, int age, List<Hobby> humanHobbys) {
    this.name = name;
    this.age = age;
    this.humanHobbys = humanHobbys;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<Hobby> getHumanHobbys() {
    return humanHobbys;
  }

  public void setHumanHobbys(List<Hobby> humanHobbys) {
    this.humanHobbys = humanHobbys;
  }

  @Override
  public String toString() {
    return "Human [name=" + name + ", age=" + age + ", humanHobbys=" + humanHobbys + "]";
  }

}
