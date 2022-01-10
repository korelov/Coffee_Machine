package machine;

import java.util.Scanner;

public class CoffeeMachine {

    final static Scanner scanner = new Scanner(System.in);
    final static int WATER = 200;
    final static int MILK = 50;
    final static int COFFEE_BEANS = 15;


    public static void ingredientCalculator() {

        System.out.print("Write how many cups of coffee you will need: \n" +
                "> ");
        int cupsOfCoffee = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:%n", cupsOfCoffee);
        System.out.printf("%d ml of water%n", cupsOfCoffee * WATER);
        System.out.printf("%d ml of milk%n", cupsOfCoffee * MILK);
        System.out.printf("%d g of coffee beans%n", cupsOfCoffee * COFFEE_BEANS);
    }

    public static void main(String[] args) {

        ingredientCalculator();

//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!");

    }
}
