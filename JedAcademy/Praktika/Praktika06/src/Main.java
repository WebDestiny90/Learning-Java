public class Main {
  public static void main(String[] args) {
    var carInfo = new CarInfo("BMW", "Black");
    var carInfo2 = new CarInfo("Mercedes", "white");
    var carInfo3 = new CarInfo("Hyundai", "blue");
    var carInfo4 = new CarInfo("Toyota", "Black");


    CarInfo[] carList = {carInfo, carInfo2, carInfo3, carInfo4};
    for (CarInfo car : carList) {
      if (car.getColor().equals("Black")) {
        System.out.println(car);
      }
    }
  }
}