import java.util.Map;

public class Student<F, K, V> {
  private F name;
  private F surname;
  private Map<K, V> grade;

  public Student(F name, F surname, Map<K, V> grade) {
    this.name = name;
    this.surname = surname;
    this.grade = grade;
  }

  public F getName() {
    return name;
  }

  public void setName(F name) {
    this.name = name;
  }

  public F getSurname() {
    return surname;
  }

  public void setSurname(F surname) {
    this.surname = surname;
  }

  public Map<K, V> getGrade() {
    return grade;
  }

  public void setGrade(Map<K, V> grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student{" + "name=" + name + ", surname=" + surname + ", grade=" + grade + '}';
  }
}
