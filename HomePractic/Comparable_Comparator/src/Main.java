import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    var cars = new Car("BMW", 2025, 4.4);
    var cars2 = new Car("BMW", 2021, 3.2);
    var cars3 = new Car("BMW", 1650, 1.2);
    var cars4 = new Car("BMW", 1995, 2.4);

    List<Car> myCars = Arrays.asList(cars, cars2, cars3, cars4);

    Collections.sort(myCars, new CarName());

    myCars.forEach(System.out::println);
  }
}