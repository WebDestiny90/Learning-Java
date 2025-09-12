package student;

public class Student {
  private String name;
  private Integer age;
  private double grade;

  public Student(String name, Integer age, double grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
  }

}
