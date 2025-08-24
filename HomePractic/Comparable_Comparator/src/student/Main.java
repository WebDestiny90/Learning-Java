package student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var student1 = new Student("Taleh", 20, 0.1);
    var student3 = new Student("Vusal", 20, 5.1);
    var student2 = new Student("Togrul", 20, 10.1);
    var student4 = new Student("Asif", 20, 8.1);

    List<Student> studentList = Arrays.asList(student1, student2, student3, student4);

    // Collections.sort(studentList, new StudentNameCompare());

    studentList.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));

    studentList.forEach(System.out::println);
  }
}
