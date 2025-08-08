import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //    Map<Integer, String> names = new HashMap<>();
    //    names.put(1, "Taleh");
    //    names.put(2, "Vusal");
    //    names.put(3, "Togrul");
    //    names.put(4, "Asif");
    //
    //    for (Integer key : names.keySet()) {
    //      String ad = names.get(key);
    //
    //      if (ad.toLowerCase().contains("a")) {
    //        System.out.println("ID: " + key + " - Ad: " + ad);
    //      }
    //    }

    Human human = new Human(0543001l, "Taleh", "Aghayev", 34);

    Map<Long, Human> info = new HashMap<>();

    info.put(human.getId(), human);

    System.out.println(info);
  }
}
