import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // int[] numbers = {50,60,90,70,80,150,350,650};
    //
    // int max1 = numbers[0];
    // for (int i = 1; i < numbers.length; i++) {
    // if (numbers[i] > max1) {
    // max1 = numbers[i];
    // }
    // }
    //
    // int max2 = numbers[0];
    // for (int i = 1; i < numbers.length; i++) {
    // if (numbers[i] > max2 && numbers[i] < max1) {
    // max2 = numbers[i];
    // }
    // }
    //
    // System.out.println(max1 + " " + max2);

    var myHobby = new Hobby("Painting", 15);
    var myHobby2 = new Hobby("EGaming", 18);
    var myHobby3 = new Hobby("Riding", 19);
    var myHobby4 = new Hobby("Car Collection", 35);
    var myHobby5 = new Hobby("Sleeping", 0);

    List<Hobby> hobbies = Arrays.asList(myHobby, myHobby2);
    List<Hobby> hobbie2 = Arrays.asList(myHobby);
    List<Hobby> hobbie3 = Arrays.asList(myHobby, myHobby2);
    List<Hobby> hobbie4 = Arrays.asList(myHobby, myHobby2, myHobby3);

    var humanInfo = new Human("Taleh", 22, hobbies);
    var humanInfo2 = new Human("Vusal", 20, hobbie2);
    var humanInfo3 = new Human("Toghrul", 21, hobbie3);
    var humanInfo4 = new Human("Asif", 19, hobbie4);

    List<Human> humans = Arrays.asList(humanInfo, humanInfo2, humanInfo3, humanInfo4);

    List<Hobby> filteredHobbies = new ArrayList<>();

    for (Hobby h : hobbies) {
      if (humanInfo.getAge() >= h.getMinimumAge()) {
        filteredHobbies.add(h);
      }
    }

    hobbies = filteredHobbies;

    for (Hobby h : hobbies) {
      System.out.println(h.getName() + " - " + h.getMinimumAge());
    }

  }
}
