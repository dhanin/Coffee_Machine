package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();

        while (true) {
            coffee.getAction();
            if (coffee.getMode().equals("buy"))
                coffee.buyCoffee();
            if  (coffee.getMode().equals("fill"))
                coffee.doFill();
            if  (coffee.getMode().equals("take"))
                coffee.doTake();
            if (coffee.getMode().equals("remaining"))
                coffee.printStatus();
            if (coffee.getMode().equals("exit"))
                return;
        }

    }
    public static class Coffee {
        private int water;
        private int milk;
        private int bean;
        private int cup;
        private int money;
        String mode;

        public Coffee() {
            water = 400;
            milk = 540;
            bean = 120;
            cup = 9;
            money = 550;
        }
        public void printStatus() {
            System.out.printf("The coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n" +
                    "%d of disposable cups\n%d of money\n\n" ,water,milk,bean,cup,money);
        }
        public void getAction() {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            this.mode = scanner.next();
            System.out.println();
        }
        public String getMode() {
            return this.mode;
        }
        public void buyCoffee() {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            Scanner scanner = new Scanner(System.in);
            String type = scanner.next();
            System.out.println();
            switch (type) {
                case "1":
                    doEspresso();
                    break;
                case "2":
                    doLatte();
                    break;
                case "3":
                    doCappuccino();
                    break;
                case "back":
                    getAction();
                    return;
            }

        }
        public void doEspresso() {
            if (water < 250) {
                System.out.println("Sorry, not enough water!");
                System.out.println();
                return;
            } else if (bean < 16) {
                System.out.println("Sorry, not enough coffee beans!");
                System.out.println();
                return;
            } else if (cup < 1) {
                System.out.println("Sorry, not enough disposable cups!");
                System.out.println();
                return;
            } else {
                water -= 250;
                bean -= 16;
                money += 4;
                cup--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
        public void doLatte() {
            if (water < 350) {
                System.out.println("Sorry, not enough water!");
                System.out.println();
                return;
            } else if (milk < 75) {
                System.out.println("Sorry, not enough milk!");
                System.out.println();
                return;
            } else if (bean < 20) {
                System.out.println("Sorry, not enough coffee beans!");
                System.out.println();
                return;
            } else if (cup < 1) {
                System.out.println("Sorry, not enough disposable cups!");
                System.out.println();
                return;
            } else {
                water -= 350;
                milk -= 75;
                bean -= 20;
                money += 7;
                cup--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
        public void doCappuccino() {
            if (water < 200) {
                System.out.println("Sorry, not enough water!");
                System.out.println();
                return;
            } else if (milk < 100) {
                System.out.println("Sorry, not enough milk!");
                System.out.println();
                return;
            } else if (bean < 12) {
                System.out.println("Sorry, not enough coffee beans!");
                System.out.println();
                return;
            } else if (cup < 1) {
                System.out.println("Sorry, not enough disposable cups!");
                System.out.println();
                return;
            } else {
                water -= 200;
                milk -= 100;
                bean -= 12;
                money += 6;
                cup--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
        public void doFill() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water do you want to add:");
            water += scanner.nextInt();
            System.out.println("Write how many ml of milk do you want to add:");
            milk += scanner.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add:");
            bean += scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add:");
            cup += scanner.nextInt();
            System.out.println();
        }
        public void doTake() {
            System.out.printf("I gave you $%d\n\n", money);
            money = 0;
        }
    }
}
