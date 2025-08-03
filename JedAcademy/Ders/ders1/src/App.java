import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // int[] myArray = { 1, 2, 3, 4, 5 };

        // for (int i = myArray.length - 1; i > 0; i--) {
        // System.out.println(myArray[i]);
        // }

        // for (int i = myArray.length - 1; i > 0; i--) {
        // if (i == 3) {
        // continue;
        // }
        // System.out.println(myArray[i]);
        // }

        // int sum = 0;

        // for (int i = myArray.length - 1; i >= 0; i--) {
        // sum += myArray[i];
        // }

        // System.out.println("sum: " + sum);

        // String[] myStrArray = { "Resul", "Taleh", "Nergiz" };

        // for (int i = 0; i < myStrArray.length; i++) {
        // if (myStrArray[i].equals("Resul")) {
        // System.out.println("user online");
        // }
        // }
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter user name:");
        // String userName = scanner.next();

        // System.out.println("Enter user password:");
        // String userPassword = scanner.next();

        // String[][] users = {
        // { "Taleh", "123456" },
        // { "Resul", "123457" },
        // { "Togrul", "123458" },
        // { "Vusal", "123459" }
        // };

        // boolean found = false;

        // for (int i = 0; i < users.length; i++) {
        // if (users[i][0].equals(userName) && users[i][1].equals(userPassword)) {
        // System.out.println(userName + " is online");
        // found = true;
        // break;
        // }
        // }

        // if (!found) {
        // System.out.println("Invalid username or password.");
        // }
        // scanner.close();

        // int[] numbersArray = { 5, 10, 15, 20, 25, 30, 40, 50, 60 };

        // System.out.println("cut ededler:");
        // for (int i = 0; i < numbersArray.length; i++) {
        // if (numbersArray[i] % 2 == 0) {
        // System.out.println(numbersArray[i]);
        // }

        // }

        // int cutSay = 0;
        // int tekSay = 0;

        // for (int i = 0; i < numbersArray.length; i++) {
        // if (numbersArray[i] % 2 == 0) {
        // cutSay++;
        // } else {
        // tekSay++;
        // }
        // }

        // System.out.println("cut ededlerin sayi: " + cutSay);
        // System.out.println("tek ededlerin sayi: " + tekSay);

        // int[] numbersArray = { 5, 10, 15, 20, 25, 30, 40, 50, 60 };

        // int count = 0;
        // for (int i = 0; i < numbersArray.length; i++) {
        // if (numbersArray[i] % 2 != 0) {
        // count++;
        // }
        // }

        // int[] oddArray = new int[count];
        // int index = 0;

        // for (int i = 0; i < numbersArray.length; i++) {
        // if (numbersArray[i] % 2 != 0) {
        // oddArray[index] = numbersArray[i];
        // index++;
        // }
        // }

        // for (int i = 0; i < oddArray.length; i++) {
        // System.out.print(oddArray[i] + " ");

        // }

        // int[] numbers = { 5, 25, 45, 105, 205, 400 };
        //
        // int max = numbers[0];
        // for (int i = 1; i < numbers.length; i++) {
        // if (numbers[i] > max) {
        // max = numbers[i];
        // }
        // }
        // System.out.println("En boyuk eded: " + max);

        // int[] numbers = {1, 5, 25, 45, 105, 205, 400 };

        // int min = numbers[0];
        // for (int i = 1; i < numbers.length; i++) {
        // if (numbers[i] < min) {
        // min = numbers[i];
        // }
        // }
        // System.out.println("En kicik eded: " + min);
        // int[] numbers = { 1, 5, 25, 45, 105, 205, 400 };
        //
        // int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum += numbers[i];
        // }
        // double average = (double) sum / numbers.length;
        // System.out.println("Ededi orta: " + average);

        // int[] numbers = { 1, 5, 25, 45, 105, 205, 400 };

        // int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum += numbers[i];

        // }
        // double average = (double) sum / numbers.length;
        // System.out.println("Ededi orta: " + average);

        String[] fruits = { "apple", "mango", "banana", "apple", "kiwi", "apple" };
        int appleCount = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i].equals("apple")) {
                appleCount++;
            }
        }
        System.out.println("apple sozu " + appleCount + " defe istifade olunub.");
    }

    int[] numbsers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int[] primeArray = new int[numbsers.length];
    int[] compositeArray = new int[numbsers.length];
    int primeCount = 0;
    int compositeCount = 0;

    for(
    int i = 0;i<numbsers.length;i++)
    {
        int n = numbsers[i];
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
        } else {
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            primeArray[primeCount] = n;
            primeCount++;
        } else {
            compositeArray[compositeCount] = n;
            compositeCount++;
        }
    }

    System.out.print("Sadə ədədlər: ");for(
    int i = 0;i<primeCount;i++)
    {
        System.out.print(primeArray[i] + " ");
    }System.out.println();

    System.out.print("Mürəkkəb ədədlər: ");for(
    int i = 0;i<compositeCount;i++)
    {
        System.out.print(compositeArray[i] + " ");
    }System.out.println();
}}