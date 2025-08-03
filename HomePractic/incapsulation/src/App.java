public class App {
  public static void main(String[] args) throws Exception {
    var myCar = new CarInfo();

    System.out.println(myCar.getModel()+myCar.getYear()+myCar.getEngine()+myCar.getColor());
  }
}
