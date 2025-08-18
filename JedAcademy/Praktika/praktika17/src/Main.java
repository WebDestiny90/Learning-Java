import java.util.*;

public class Main {

  public static void main(String[] args) {
    var person = new Person("Taleh", 250);
    var person2 = new Person("Vusal", 1750);
    var person3 = new Person("Toghrul", 450);
    var person4 = new Person("Asif", 1350);

    List<Person> persons = List.of(person, person2, person3, person4);

    persons.stream().filter(p -> p.getAmount() > 1000).forEach(System.out::println);
  }


}
