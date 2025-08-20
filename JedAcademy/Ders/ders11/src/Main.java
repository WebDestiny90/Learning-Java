import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("Taleh", 34));
    students.add(new Student("Vusal", 24));
    students.add(new Student("Toghrul", 27));

    Collections.sort(students);

    for (Student s : students) {
      System.out.println(s);
    }
  }
}
