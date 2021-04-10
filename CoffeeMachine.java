package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineMethod coffeeMachine = new CoffeeMachineMethod();
        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
        String input = scanner.nextLine();
        while (!(input.equals("exit"))) {
            coffeeMachine.coffeeMachine(input);
            input = scanner.nextLine();
        }
    }
}

class CoffeeMachineMethod {
    enum coffeeMachineState {
        ACTION_PROMPT, BUY_PROMPT, WATER_FILL_PROMPT,
        MILK_FILL_PROMPT, COFFEE_BEANS_FILL_PROMPT, CUPS_FILL_PROMPT
    }
    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;
    coffeeMachineState state = coffeeMachineState.ACTION_PROMPT;
    public void coffeeMachine(String input) {
        switch (state) {
            case ACTION_PROMPT:
                switch (input) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        state = coffeeMachineState.BUY_PROMPT;
                        return;
                    case "fill":
                        System.out.println("Write how many ml of water do you want to add:");
                        state = coffeeMachineState.WATER_FILL_PROMPT;
                        return;
                    case "take":
                        System.out.println("I gave you $" + money + "\n");
                        money = 0;
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                    case "remaining":
                        System.out.println("The coffee machine has:");
                        System.out.println(water + " of water");
                        System.out.println(milk + " of milk");
                        System.out.println(beans + " of coffee beans");
                        System.out.println(cups + " of disposable cups");
                        System.out.println("$" + money + " of money\n");
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                }
            case BUY_PROMPT:
                switch (input) {
                    case "1":
                        if (water >= 250) {
                            if (beans >= 16) {
                                if (cups >= 1) {
                                    System.out.println("I have enough resources, making you a coffee!");
                                    water -= 250;
                                    beans -= 16;
                                    money += 4;
                                    cups -= 1;
                                } else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            } else {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                        } else {
                            System.out.println("Sorry, not enough water!");
                        }
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                    case "2":
                        if (water >= 350) {
                            if (milk >= 75) {
                                if (beans >= 20) {
                                    if (cups >= 1) {
                                        System.out.println("I have enough resources, making you a coffee!");
                                        water -= 350;
                                        milk -= 75;
                                        beans -= 20;
                                        money += 7;
                                        cups -= 1;
                                    } else {
                                        System.out.println("Sorry, not enough cups!");
                                    }
                                } else {
                                    System.out.println("Sorry, not enough coffee beans!");
                                }
                            } else {
                                System.out.println("Sorry, not enough milk!");
                            }
                        } else {
                            System.out.println("Sorry, not enough water!");
                        }
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                    case "3":
                        if (water >= 200) {
                            if (milk >= 100) {
                                if (beans >= 12) {
                                    if (cups >= 1) {
                                        System.out.println("I have enough resources, making you a coffee!");
                                        water -= 200;
                                        milk -= 100;
                                        beans -= 12;
                                        money += 6;
                                        cups -= 1;
                                    } else {
                                        System.out.println("Sorry, not enough cups!");
                                    }
                                } else {
                                    System.out.println("Sorry, not enough coffee beans!");
                                }
                            } else {
                                System.out.println("Sorry, not enough milk!");
                            }
                        } else {
                            System.out.println("Sorry, not enough water!");
                        }
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                    case "back":
                        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                        state = coffeeMachineState.ACTION_PROMPT;
                        return;
                }
            case WATER_FILL_PROMPT:
                water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk do you want to add:");
                state = coffeeMachineState.MILK_FILL_PROMPT;
                return;
            case MILK_FILL_PROMPT:
                milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                state = coffeeMachineState.COFFEE_BEANS_FILL_PROMPT;
                return;
            case COFFEE_BEANS_FILL_PROMPT:
                beans += Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                state = coffeeMachineState.CUPS_FILL_PROMPT;
                return;
            case CUPS_FILL_PROMPT:
                cups += Integer.parseInt(input);
                System.out.println("Write action (buy, fill, take, remaining, exit):\n");
                state = coffeeMachineState.ACTION_PROMPT;
                return;
        }
        System.out.println();
    }   
}
