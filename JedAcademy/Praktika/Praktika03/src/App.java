// import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Yeni yashi yazin: ");
    // int newAge = scanner.nextInt();
    // System.out.println("adi daxil edin: ");
    // String newName = scanner.next();

    // var human = new Human();
    // human.setInfo(newAge, newName);

    // System.out.println("Yeni Yash: " + human.getAge() + " Yeni AD: " +
    // human.getName());

    // scanner.close();

    Customer customer = new Customer();

    customer.setId("001");
    customer.setName("Taleh");
    customer.setSurName("Aghayev");
    customer.setAge(25);
    customer.setBalance(2250.50);

    String result = String.format(
        "Customer Info:\nID: %s\nName: %s\nSurname: %s\nAge: %d\nBalance: %.2f",
        customer.getId(),
        customer.getName(),
        customer.getSurName(),
        customer.getAge(),
        customer.getBalance());

    System.out.println(result);

  }
}
