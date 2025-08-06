import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    //    Map<String, String> student = new HashMap<>();
    //    student.put("name", "Taleh");
    //    student.put("surname", "Agayev");
    //    student.put("age", "34");
    //
    //    System.out.println(student);

    List<Map<String, String>> transaction = new ArrayList<>();

    Map<String, String> info1 = new HashMap<>();
    info1.put("name", "Taleh");
    info1.put("transactionAmount", "200");
    transaction.add(info1);

    Map<String, String> info12 = new HashMap<>();
    info12.put("name", "Taleh");
    info12.put("transactionAmount", "250");
    transaction.add(info12);

    Map<String, String> info2 = new HashMap<>();
    info2.put("name", "Vusal");
    info2.put("transactionAmount", "50");
    transaction.add(info2);

    Map<String, String> info3 = new HashMap<>();
    info3.put("name", "Togrul");
    info3.put("transactionAmount", "150");
    transaction.add(info3);

    Map<String, String> info4 = new HashMap<>();
    info4.put("name", "Aytac");
    info4.put("transactionAmount", "90");
    transaction.add(info4);

    Map<String, String> info5 = new HashMap<>();
    info5.put("name", "Nigar");
    info5.put("transactionAmount", "300");
    transaction.add(info5);

    int count = 0;

    for (Map<String, String> t : transaction) {
      int amount = Integer.parseInt(t.get("transactionAmount"));
      if (amount > 100) {
        System.out.println("Name: " + t.get("name") + ", Transaction Amount: " + t.get("transactionAmount"));
        count++;
      }
    }

    System.out.println("100-dən çox olan transaction sayı: " + count);
  }


}