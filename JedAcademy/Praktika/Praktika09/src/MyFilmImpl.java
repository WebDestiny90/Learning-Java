import java.time.LocalDate;
import java.util.Arrays;

public class MyFilmImpl implements Myfilm{
  private String name;
  private String[] categoty;
  private LocalDate year;

  @Override
  public String name() {
    return name;
  }

  @Override
  public String[] category() {
    return new String[0];
  }

  @Override
  public LocalDate year(LocalDate year) {
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getCategoty() {
    return categoty;
  }

  public void setCategoty(String[] categoty) {
    this.categoty = categoty;
  }

  public LocalDate getYear() {
    return year;
  }

  public void setYear(LocalDate year) {
    this.year = year;
  }

  public MyFilmImpl(String name, String[] categoty, LocalDate year) {
    this.name = name;
    this.categoty = categoty;
    this.year = year;
  }

  @Override
  public String toString() {
    return "MyFilmImpl{" + "name='" + name + '\'' + ", categoty=" + Arrays.toString(categoty) + ", year=" + year + '}';
  }
}
