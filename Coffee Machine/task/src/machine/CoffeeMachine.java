package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static final int WATER = 200;
    static final int MILK = 50;
    static final int COFFEE_BEANS = 15;
    static int waterCoffeeMachineHas;
    static int milkCoffeeMachineHas;
    static int coffeeBeansCoffeeMachineHas;
    static int cupsOfCoffee;

    public static void estimateNumberServings() {

        System.out.println("Write how many ml of water the coffee machine has:");
        waterCoffeeMachineHas = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkCoffeeMachineHas = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansCoffeeMachineHas = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cupsOfCoffee = scanner.nextInt();
    }

    public static void showAmountCoffee() {

        int[] arr = {waterCoffeeMachineHas / WATER, milkCoffeeMachineHas / MILK, coffeeBeansCoffeeMachineHas / COFFEE_BEANS};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        if (cupsOfCoffee == min) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsOfCoffee > min) {
            System.out.printf("No, I can make only %d cup(s) of coffee", min);
        } else if (cupsOfCoffee < min) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", min - cupsOfCoffee);
        }
    }

    public static void main(String[] args) {

        estimateNumberServings();
        showAmountCoffee();
    }
}
