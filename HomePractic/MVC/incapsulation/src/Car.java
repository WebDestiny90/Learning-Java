public class Car {
  private String model;
  private String mark;
  private String color;
  private int year;
  private double engine;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
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
    return "Car{" + "model='" + model + '\'' + ", mark='" + mark + '\'' + ", color='" + color + '\'' + ", year=" + year + ", engine=" + engine + '}';
  }
}
