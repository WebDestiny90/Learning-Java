import java.util.Comparator;

public class CarName implements Comparator<Car> {

  @Override
  public int compare(Car o1, Car o2) {
    int m = o1.getModel().compareTo(o2.getModel());
    int y = o1.getYear().compareTo(o2.getYear());

    return (m == 0) ? y : m;
  }
}
