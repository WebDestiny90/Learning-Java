import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Map<String, String>> transaction = new ArrayList<>();

    Map<String, String> info1 = new HashMap<>();
    info1.put("name", "Taleh");
    info1.put("transactionAmount", "200");
    transaction.add(info1);

    Map<String, String> info2 = new HashMap<>();
    info2.put("name", "Taleh");
    info2.put("transactionAmount", "250");
    transaction.add(info2);

    Map<String, String> info3 = new HashMap<>();
    info3.put("name", "Vusal");
    info3.put("transactionAmount", "50");
    transaction.add(info3);

    Map<String, String> info4 = new HashMap<>();
    info4.put("name", "Vusal");
    info4.put("transactionAmount", "50");
    transaction.add(info4);

    Map<String, String> info5 = new HashMap<>();
    info5.put("name", "Togrul");
    info5.put("transactionAmount", "150");
    transaction.add(info5);

    Map<String, String> info6 = new HashMap<>();
    info6.put("name", "Togrul");
    info6.put("transactionAmount", "100");
    transaction.add(info6);

    Map<String, String> info7 = new HashMap<>();
    info7.put("name", "Aytac");
    info7.put("transactionAmount", "90");
    transaction.add(info7);

    Map<String, String> info8 = new HashMap<>();
    info8.put("name", "Asif");
    info8.put("transactionAmount", "300");
    transaction.add(info8);

    Map<String, Integer> totalTransactionPerPerson = new HashMap<>();

    for (Map<String, String> t : transaction) {
      int amount = Integer.parseInt(t.get("transactionAmount"));
      String personName = t.get("name");

      if (totalTransactionPerPerson.containsKey(personName)) {
        int changeAble = totalTransactionPerPerson.get(personName);
        totalTransactionPerPerson.put(personName, changeAble + amount);

      } else {
        totalTransactionPerPerson.put(personName, amount);
      }
    }
    System.out.println(totalTransactionPerPerson);
  }


}