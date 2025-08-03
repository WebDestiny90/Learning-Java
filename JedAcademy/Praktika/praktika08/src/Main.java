import myInterfaces.Customers;
import myInterfaces.KapitalBank;
import myInterfaces.Shop;

public class Main {
  public static void main(String[] args) {
    //    var book = new Melikmemmed();
    //
    //    book.name();
    //    book.page();
    //    book.auth();

    var phone = new Shop("Mi 12Lite", 850.20);
    var watch = new Shop("Samsung Watch4", 520.55);
    var customer = new Customers("Taleh", 10500.5);
    var bank = new KapitalBank();

    double oldBalans = customer.getAmount();

    customer.setAmount(customer.getAmount() - watch.getPrice());
    customer.setAmount(customer.getAmount() - phone.getPrice());
    System.out.println(bank.pay() + " " + "Evvelki Balans! " + oldBalans + " " + " Yeni Balans " + customer.getAmount());
  }
}