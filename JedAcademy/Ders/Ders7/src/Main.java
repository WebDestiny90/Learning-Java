import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {

    TreeSet<Students> studentsSet = new TreeSet<>();
    studentsSet.add(new Students("Taleh", "Vusal", "Togrul"));


    for (Students student : studentsSet) {
      if (student.getName().equals("Taleh")) {
        System.out.println(student.getName());
      }
    }
  }
}