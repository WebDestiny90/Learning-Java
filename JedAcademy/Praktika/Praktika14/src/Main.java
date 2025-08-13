import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //    Map<String, Integer> bal = new HashMap<>();
    //    bal.put("Riyaziyyat", 95);
    //    bal.put("Fizika", 88);
    //    bal.put("Kimya", 91);
    //
    //    Student<String, String, Integer> student = new Student<>("Taleh", "Aghayev", bal);
    //
    //    System.out.println(student);

    //    Box<String> box = new Box<>();
    //
    //    box.setItem("Taleh ");
    //
    //    Box<Integer> box2 = new Box<>();
    //
    //    box2.setItem(23);
    //
    //    System.out.println(box.getItem() + box2.getItem());

    List<Integer> myList = new ArrayList<>();
    Container container = new Container(myList);

    container.addItem(5);
    container.addItem(2);
    container.addItem(1);
    container.addItem(6);
    container.addItem(9);
    container.addItem(8);

    System.out.println(container.getList(3));
  }
}
