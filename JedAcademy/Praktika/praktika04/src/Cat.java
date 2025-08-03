public class Cat extends Animal{

  public String meow;

  public Cat(String name, int age, String color, double weight, String species,String meow) {
    super(name, age, color, weight, species);
    this.meow = meow;
  }

  @Override
  public String toString() {
    return "Cat{" + "meow='" +
            "Cat{" + super.toString() +
            meow + '\'' + '}';
  }
}
