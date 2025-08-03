package myInterfaces;

public class KapitalBank implements Payment {
  @Override
  public String pay() {
    return "Odeme Kapital bank vasitesi ile heyata kecirildi!";
  }
}
