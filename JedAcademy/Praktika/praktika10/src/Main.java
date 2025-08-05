import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    System.out.println("Meyvenin adini daxil edin (Apple), (Banana), (Kiwi), (Pineaple) ");
//    Scanner scanner = new Scanner(System.in);
//    String userAnswer = scanner.next();
//    ArrayList<String> fruits = new ArrayList<>();
//
//    fruits.add("Apple");
//    fruits.add("Banana");
//    fruits.add("Kiwi");
//    fruits.add("pineaple");
//
//    if (fruits.contains(userAnswer)) {
//      fruits.remove(userAnswer);
//    }else {
//      System.out.println("The fruit is not in the list.");
//    }
//
//    System.out.println(fruits);
    Human human = new Human("Taleh", "Agayev", 185, 60,"Male");
    Human human2 = new Human("Vusal", "Huseynov", 167, 60,"Male");
    Human human3 = new Human("Aytac", "Bagirova", 157, 55,"Female");
    Human human4 = new Human("Togrul", "Bagirov", 183, 70,"Male");
    List<Human> humans = List.of(human, human2, human3, human4);

    int maleCount = 0;
    int femaleCount = 0;

    for (Human h : humans) {
      if ("Female".equals(h.getGender())) {
        femaleCount++;
      } else if ("Male".equals(h.getGender())) {
        maleCount++;
      }
    }

    System.out.println("Male: " + maleCount);
    System.out.println("Female: " + femaleCount);

  }
}