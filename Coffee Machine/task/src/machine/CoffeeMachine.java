package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);

    static final int ESP_WATER = 250;
    static final int ESP_MILK = 0;
    static final int ESP_C_BEAN = 16;
    static final int ESP_MONEY = 4;

    static final int LAT_WATER = 350;
    static final int LAT_MILK = 75;
    static final int LAT_C_BEAN = 20;
    static final int LAT_MONEY = 7;

    static final int CAP_WATER = 200;
    static final int CAP_MILK = 100;
    static final int CAP_C_BEAN = 12;
    static final int CAP_MONEY = 6;

    static int waterCoffeeMachineHas = 400;
    static int milkCoffeeMachineHas = 540;
    static int coffeeBeansCoffeeMachineHas = 120;
    static int disposableCupsHas = 9;
    static int moneyHas = 550;

    static int cupsOfCoffee;


//    public static void estimateNumberServings() {
//
//        System.out.println("Write how many ml of water the coffee machine has:");
//        waterCoffeeMachineHas = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        milkCoffeeMachineHas = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        coffeeBeansCoffeeMachineHas = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need:");
//        cupsOfCoffee = scanner.nextInt();
//    }

    public static void showCMStat() {
        System.out.println("The coffee machine has:\n" +
                "" + waterCoffeeMachineHas + " ml of water\n" +
                "" + milkCoffeeMachineHas + " ml of milk\n" +
                "" + coffeeBeansCoffeeMachineHas + " g of coffee beans\n" +
                "" + disposableCupsHas + " disposable cups\n" +
                "$" + moneyHas + " of money\n");
    }

//    public static void showAmountCoffee() {
//
//        int[] arr = {waterCoffeeMachineHas / WATER, milkCoffeeMachineHas / MILK, coffeeBeansCoffeeMachineHas / COFFEE_BEANS};
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//        }
//        if (cupsOfCoffee == min) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (cupsOfCoffee > min) {
//            System.out.printf("No, I can make only %d cup(s) of coffee%n", min);
//        } else if (cupsOfCoffee < min) {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", min - cupsOfCoffee);
//        }
//        startMenu();
//    }

    public static void takeMoney() {

        System.out.printf("I gave you $%d%n", moneyHas);
        moneyHas = moneyHas - moneyHas;
        System.out.println();
        showCMStat();
    }

    public static void chooseCoffe() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int chooseNumber = scanner.nextInt();
        switch (chooseNumber) {
            case 1:
                waterCoffeeMachineHas = waterCoffeeMachineHas - ESP_WATER;
                milkCoffeeMachineHas = milkCoffeeMachineHas - ESP_MILK;
                coffeeBeansCoffeeMachineHas = coffeeBeansCoffeeMachineHas - ESP_C_BEAN;
                disposableCupsHas = disposableCupsHas - 1;
                moneyHas = moneyHas + ESP_MONEY;
                showCMStat();
                break;
            case 2:
                waterCoffeeMachineHas = waterCoffeeMachineHas - LAT_WATER;
                milkCoffeeMachineHas = milkCoffeeMachineHas - LAT_MILK;
                coffeeBeansCoffeeMachineHas = coffeeBeansCoffeeMachineHas - LAT_C_BEAN;
                disposableCupsHas = disposableCupsHas - 1;
                moneyHas = moneyHas + LAT_MONEY;
                showCMStat();
                break;
            case 3:
                waterCoffeeMachineHas = waterCoffeeMachineHas - CAP_WATER;
                milkCoffeeMachineHas = milkCoffeeMachineHas - CAP_MILK;
                coffeeBeansCoffeeMachineHas = coffeeBeansCoffeeMachineHas - CAP_C_BEAN;
                disposableCupsHas = disposableCupsHas - 1;
                moneyHas = moneyHas + CAP_MONEY;
                showCMStat();
                break;
        }
    }

    public static void fillOption() {
        System.out.println("Write how many ml of water you want to add:");
        waterCoffeeMachineHas = waterCoffeeMachineHas + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkCoffeeMachineHas = milkCoffeeMachineHas + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansCoffeeMachineHas = coffeeBeansCoffeeMachineHas + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCupsHas = disposableCupsHas + scanner.nextInt();
        showCMStat();
    }

    public static void startMenu() {
        showCMStat();

        System.out.println("Write action (buy, fill, take):");
        String menuStart = scanner.next();
        if (!menuStart.equals("buy") && !menuStart.equals("fill") && !menuStart.equals("take") && !menuStart.equals("exit")) {
            startMenu();
        }
        switch (menuStart) {
            case "buy":
                chooseCoffe();
                break;
            case "fill":
                fillOption();
                break;
            case "take":
                takeMoney();
                break;
        }
    }

    public static void main(String[] args) {
        startMenu();
    }
}
