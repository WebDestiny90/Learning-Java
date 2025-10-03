public class Cars extends Car {
  public void carsInfo() {
    setMark("Mercedes-Benz ");
    setModel("C300 ");
    setColor("Gray ");
    setYear(2020);
    setEngine(1.0);

    System.out.println(getMark() + getModel() + getColor() + getYear() + getEngine());
  }
}
