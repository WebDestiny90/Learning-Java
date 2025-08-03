public class Car {
  private String model;
  private String color;
  private String engine;
  private int year;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Car{" +
            "model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", engine='" + engine + '\'' +
            ", year=" + year +
            '}';
  }
}
