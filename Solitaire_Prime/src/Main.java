// Pulkit Verma
// Class (CECS 274-05)
// Project Name (Prog 2 - Solitaire Prime)
// Due Date (Oct 2, 2018)

import java.util.Scanner;

public class Main {

    // This method returns true if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num % 2 == 0 && num != 2) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < squareRoot; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // This method prints the menu on the screen
    public static void printMenu() {
        System.out.println("Welcome to Solitaire Prime!\n1) New Deck\n2) Display Deck\n3) Shuffle Deck\n4) Play Solitaire Prime\n5) Exit\n");
    }

    // This method returns the menuOption selected by the user
    public static int menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please select a menu option: ");
        int menuOption = input.nextInt();

        while (menuOption < 1 || menuOption > 5) {
            System.out.print("Please select a valid menu option: ");
            menuOption = input.nextInt();
        }

        return menuOption;
    }

    // This method plays Solitaire Prime
    public static void playSolitaire(Deck deck) {
        System.out.print("Playing Solitaire Prime!!!\n\n");
        int sum = 0;
        int cardsDisplayed = 0;
        int noOfPiles = 0;
        while (cardsDisplayed != 52) {
            while ((isPrime(sum) == false || sum == 0) && cardsDisplayed != 52) {
                Card card = deck.deal();
                cardsDisplayed += 1;
                card.display();
                sum += card.getValue();
                System.out.print("  ");
            }

            if (isPrime(sum) == false) {
                System.out.print("Sum: " + sum);
            } else {
                System.out.print("Prime: " + sum);
            }

            noOfPiles += 1;
            if (cardsDisplayed != 52) {
                sum = 0;
            }
            System.out.print("\n\n");
        }
        if (isPrime(sum) == true) {
            System.out.print("Winner in " + noOfPiles + " piles!\n");
        } else {
            System.out.print("Loser\n");
        }

    }

    public static void main(String[] args) {

        printMenu();
        int menuOption = menu();
        Deck deck = new Deck();

        while (menuOption != 5) {

            switch (menuOption) {
                case 1:
                    deck = new Deck();
                    break;
                case 2:
                    deck.display();
                    break;
                case 3:
                    deck.shuffle();
                    break;
                case 4:
                    playSolitaire(deck);
                    break;
            }

            System.out.print("\n");
            printMenu();
            menuOption = menu();
        }
    }
}
