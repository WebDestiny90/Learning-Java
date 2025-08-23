public class Car {
  private String model;
  private Integer year;
  private double engine;

  public Car(String model, int year, double engine) {
    this.model = model;
    this.year = year;
    this.engine = engine;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public double getEngine() {
    return engine;
  }

  public void setEngine(double engine) {
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Car{" + "model='" + model + '\'' + ", year=" + year + ", engine=" + engine + '}';
  }
}
