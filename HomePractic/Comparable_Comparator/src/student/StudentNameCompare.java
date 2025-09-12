package student;

import java.util.Comparator;

public class StudentNameCompare implements Comparator<Student> {

  @Override
  public int compare(Student o1, Student o2) {
    int studentName = o1.getName().compareTo(o2.getName());
    int studentAge = o1.getAge().compareTo(o2.getAge());

    return (studentAge == 0) ? studentName : studentAge;
  }

}
