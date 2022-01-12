package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static String menuStart;

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

    static int waterCMHas = 400;
    static int milkCMHas = 540;
    static int coffeeBeansCMHas = 120;
    static int disposableCupsHas = 9;
    static int moneyHas = 550;

    public static void showCMStat() {
        System.out.println("The coffee machine has:\n" +
                "" + waterCMHas + " ml of water\n" +
                "" + milkCMHas + " ml of milk\n" +
                "" + coffeeBeansCMHas + " g of coffee beans\n" +
                "" + disposableCupsHas + " disposable cups\n" +
                "$" + moneyHas + " of money\n");
    }

    public static void takeMoney() {
        System.out.printf("I gave you $%d%n", moneyHas);
        moneyHas -= moneyHas;
    }

    public static void chooseCoffee() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        menuStart = scanner.next();

        switch (menuStart) {

            case "1":
                if (waterCMHas < ESP_WATER) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeansCMHas < ESP_C_BEAN) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterCMHas -= ESP_WATER;
                    coffeeBeansCMHas -= ESP_C_BEAN;
                    disposableCupsHas--;
                    moneyHas += ESP_MONEY;
                }
                break;
            case "2":
                if (waterCMHas < LAT_WATER) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkCMHas < LAT_MILK) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeansCMHas < LAT_C_BEAN) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterCMHas -= LAT_WATER;
                    milkCMHas -= LAT_MILK;
                    coffeeBeansCMHas -= LAT_C_BEAN;
                    disposableCupsHas--;
                    moneyHas += LAT_MONEY;
                }
                break;
            case "3":
                if (waterCMHas < CAP_WATER) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkCMHas < CAP_MILK) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeansCMHas < CAP_C_BEAN) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterCMHas -= CAP_WATER;
                    milkCMHas -= CAP_MILK;
                    coffeeBeansCMHas -= CAP_C_BEAN;
                    disposableCupsHas--;
                    moneyHas += CAP_MONEY;
                }
                break;
            case "back":
                startMenu();
                break;
        }
    }

    public static void fillOption() {

        System.out.println("Write how many ml of water you want to add:");
        waterCMHas += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkCMHas += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansCMHas += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCupsHas += scanner.nextInt();
    }

    public static void startMenu() {

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            menuStart = scanner.next();

            switch (menuStart) {
                case "buy":
                    chooseCoffee();
                    break;
                case "fill":
                    fillOption();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showCMStat();
                    break;
                case "exit":
                    System.out.println();
                    break;
            }
        } while (!menuStart.equals("exit"));
    }

    public static void main(String[] args) {
        startMenu();
    }
}
