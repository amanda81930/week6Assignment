package JavaFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner usrChoice = new Scanner(System.in);

    while (true) {

      System.out.println("Do you wish to play a new War game?");
      System.out.println("Enter y for yes or n for no: ");
      String input = usrChoice.nextLine();

      if (input.equals("y") || input.equals("Y")) {

        Deck newDeck = new Deck();

        /*
         * for (Card card: newDeck.cardsList) { card.describeCard(); }
         */

        System.out.println("Please enter a name for Player 1: ");
        String p1Name = usrChoice.nextLine();
        System.out.println("Please enter a name for Player 2: ");
        String p2Name = usrChoice.nextLine();

        System.out.println("\nInitializing game...\n");

        List<Card> p1Hand = new ArrayList<Card>();
        List<Card> p2Hand = new ArrayList<Card>();

        Player playerOne = new Player(p1Name, p1Hand);
        Player playerTwo = new Player(p2Name, p2Hand);

        System.out.println("\t...Shuffling...\n");
        newDeck.shuffle();

        System.out.println("\t\t...Cards dealt - let's play!!\n");
        for (int i = 0; i < 52; i++) {

          if (i % 2 == 0) {
            p1Hand.add(newDeck.draw());
          }

          else {
            p2Hand.add(newDeck.draw());
          }

        }

        for (int c = 1; c < 27; c++) {
          System.out.println("---------------");
          System.out.println("*Round " + c + "*\n");
          Card card1 = playerOne.flip();
          System.out.println("Player 1: " + playerOne.getName());
          card1.describeCard();
          Card card2 = playerTwo.flip();
          System.out.println("Player 2: " + playerTwo.getName());
          card2.describeCard();


          if (card1.getValue() > card2.getValue()) {
            playerOne.incrementScore();
            System.out.println("     -----     ");
            System.out.println("Round " + c + " point goes to: [" + playerOne.getName() + "]");
//            System.out.println("[" + playerOne.getName() + "] wins the point for round " + c + "!");
            System.out.println("---------------\n");
          } else if (card1.getValue() < card2.getValue()) {
            playerTwo.incrementScore();
            System.out.println("     -----     ");
            System.out.println("Round " + c + " point goes to: [" + playerTwo.getName() + "]");
//            System.out.println("[" + playerTwo.getName() + "] wins the point for round " + c + "!");
            System.out.println("---------------\n");
          } else {
            System.out.println("     -----     ");
            System.out.println("No points. It's a draw.");
            System.out.println("---------------\n");
          }

        }
        System.out.println("---------------");
        System.out.println("FINAL SCORE: ");
        System.out.println("\tPlayer 1 - " + playerOne.getName() + ": " + playerOne.getScore());
        System.out.println("\tPlayer 2 - " + playerTwo.getName() + ": " + playerTwo.getScore());
        System.out.println("---------------\n");
        if (playerOne.getScore() > playerTwo.getScore()) {
          System.out.println(playerOne.getName().toUpperCase() + " wins the game!");
        } else if (playerOne.getScore() < playerTwo.getScore()) {
          System.out.println(playerTwo.getName().toUpperCase() + " wins the game!");

        } else {
          System.out.println("It's a draw!");

        }
        System.out.println("\n---------------\n");



      } else if (input.equals("n") || input.equals("N")) {
        System.out.println("Goodbye!");
        break;
      } else {
        System.out.println("Sorry, that was not a valid entry.");
      }
    }
    usrChoice.close();
  }
}
