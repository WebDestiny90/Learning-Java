class Animal {
  private String name;
  private int age;
  private String color;
  private double weight;
  private String species;

  public Animal(String name, int age, String color, double weight, String species) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.weight = weight;
    this.species = species;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  @Override
  public String toString() {
    return " name='" + name + '\'' + ", age=" + age + ", color='" + color + '\'' + ", weight=" + weight + ", species='" + species + '\'' + '}';
  }

  public void makeSound() {
    System.out.println("Heyvan səs çıxarır.");
  }
}



