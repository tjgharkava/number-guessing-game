package ge.temo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Welcome to Number Guessing Game!");
        do {
            playGame();
        } while(askToPlayAgain());
        System.out.println("Thanks for Playing! See You Next Time!");
    }

    public static void playGame() {
        System.out.print("Enter the number for range: ");
        int range = scanner.nextInt();

        int randomNumber = random.nextInt(range) + 1;
        int maxAttempts = 3;
        int attempts = 0;
        boolean guessed = false;

        while(attempts < maxAttempts) {
            System.out.print("Your Guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if(guess < randomNumber) {
                System.out.println("To Low!");
            } else if (guess > randomNumber) {
                System.out.println("To High!");
            } else {
                System.out.println("Congratulations! You won! You guessed in " + attempts + " attempts.");
                guessed = true;
                break;
            }
        }

        if(!guessed) {
            System.out.println("You Lost! The number was " + randomNumber + ".");
        }

        System.out.println();
    }

    public static boolean askToPlayAgain() {
        System.out.print("Wanna Play Again? (yes/no): ");
        scanner.nextLine();
        String answer = scanner.nextLine().trim().toLowerCase();

        return answer.equals("yes");
    }
}