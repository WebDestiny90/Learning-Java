public class CarInfo extends Car {

  private String model;
  private String color;

  public CarInfo(String model, String color) {
    this.model = model;
    this.color = color;
  }

  @Override
  public String toString() {
    return "CarInfo{" + "model='" + model + '\'' + ", color='" + color + '\'' + '}';
  }

  @Override
  public void model(String model) {
    System.out.println(this.model);
  }

  @Override
  public void color(String color) {
    System.out.println(this.color);
  }

  @Override
  public void displayInfo() {

  }

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
}
