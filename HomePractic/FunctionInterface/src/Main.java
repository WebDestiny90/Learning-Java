import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Persone<String> persone = new Persone();
    persone.students.add("taleh");
    persone.students.add("vusal");
    persone.students.add("toghrul");
    List<String> studentsStream = persone.students.stream().filter(name -> name.endsWith("l")).map(name -> name.toUpperCase()).toList();


    System.out.println(studentsStream);
  }
}