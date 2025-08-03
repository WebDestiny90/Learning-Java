public class Main {
  public static void main(String[] args) {
    //    var payment1 = new Cash();
    //    var payment2 = new CardPayment();
    //    var payment3 = new PayOnline();
    //
    //    Payment[] payments = {payment1, payment2, payment3};
    //
    //    for (Payment paymentMethods : payments) {
    //      paymentMethods.pay();
    //    }

    Main main = new Main();
    System.out.println(main.method("Elvin", 25));
    System.out.println(main.method("Elvin", 25, "Bakı"));
    System.out.println(main.method("Elvin", 25, "Bakı", "Azərbaycan"));

  }


  public String method(String name, int age) {
    return "Ad: " + name + ", Yaş: " + age;
  }

  public String method(String name, int age, String city) {
    return "Ad: " + name + ", Yaş: " + age + ", Şəhər: " + city;
  }

  public String method(String name, int age, String city, String country) {
    return "Ad: " + name + ", Yaş: " + age + ", Şəhər: " + city + ", Ölkə: " + country;
  }

}