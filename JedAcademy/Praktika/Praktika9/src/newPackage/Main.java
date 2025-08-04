package newPackage;

public class Main {
  public static void main(String[] args) {
    Detective[] detective = {new FingerPrint(), new HairSample(), new BloodSample(), new FootPrint()};

    for (Detective detective1 : detective) {
      detective1.analyze();
    }
  }
}
