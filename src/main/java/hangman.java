import java.util.Scanner;
import java.util.Random;

public class hangman {
  public static void main() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] guesses - {"moringa", "programming", "branch", "fruit"};

    boolean weArePlaying = true;
    while (weArePlaying) {
        System.out.println("Welcome to my game of hangman"); // moringa -> m,o,r,i,n,g,a
        char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
        int amountOfGuesses = randomWordToGuess.length; // 90
        char[] playerGuess = new char[amountOfGuesses]; // _ _ _ _ _ _

        for (int i = 0; i < playerGuess.length; i++) {
            playerGuess[i] = '_';
        }

        boolean wordIsGuessed = false;
        int tries = 0;

        while (!wordIsGuessed && tries != amountOfGuesses) {
            System.out.print("Current guesses: ");
            printArray(playerGuess);
            System.out.printf("You have %d tries left.\n", amountOfGuesses - tries);
            System.out.println("Enter a single character");
            char input = scanner.nextLine().charAt(0);
            tries++;

            if (input == '_') {
                weArePlaying = false;
                wordIsGuessed = true;
            } else {
                for (int i = 0; i < randomWordToGuess.length; i++)  {
                    if (randomWordToGuess[i] == input)  {
                        playerGuess[i] = input;
                    }
                }

                if (isTheWordGuessed(playerGuess))  {
                    wordIsGuessed = true;
                    System.out.println("You won!");
                }

            }

        }

        if (!wordIsGuessed) System.out.println("Time for guessing is over :/");
        System.out.println("Do you want to play another game?  (yes/no)");
        String anotherGame = scanner.nextLine();
        if (anotherGame.equals("no")) weArePlaying = false;
    }
    System.out.println("Game over.");

  }

  public static void printArray(char[] array) {
      for (int i = 0; i < array.length; i++) {
          System.out.print(array[i] + " ");
      }
      System.out.println();
  }

  public static boolean isTheWordGuessed(char[] array)  {
      for (int i = 0; i < array.length; i++)  {
          if (array[i] == '_') return false;
      }
      return true;
  }
}
