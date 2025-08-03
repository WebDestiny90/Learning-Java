class Dog extends Animal {
  private String bark;
  public Dog(String name, int age, String color, double weight, String species,String bark) {
    super(name, age, color, weight, species);
    this.bark = bark;
  }

  @Override
  public void makeSound() {
    System.out.println("İt hürür: Hav hav!");
  }

  public void wagTail() {
    System.out.println("İt quyruğunu yelləyir.");
  }

  @Override
  public String toString() {
    return "Dog{" + "bark='" + bark +  super.toString() +
            '\'' + '}';
  }

  public String getBark() {
    return bark;
  }

  public void setBark(String bark) {
    this.bark = bark;
  }
}

//compile time

//run time

//polymorphism