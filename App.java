package JavaFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    //a) instantiate a deck and two players & call shuffle method on deck
    Scanner usrChoice = new Scanner(System.in);

    while (true) {
      System.out.println("Do you wish to play a new War game?");
      System.out.println("Enter y for yes or n for no: ");
      String input = usrChoice.nextLine();

      if (input.equals("y") || input.equals("Y")) {
        Deck newDeck = new Deck();
       
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

        //b) Using traditional for loop, iterate 52 times using Draw method 
        System.out.println("\t\t...Cards dealt - let's play!!\n");
        for (int i = 0; i < 52; i++) {
          if (i % 2 == 0) {
            p1Hand.add(newDeck.draw());
          } //end of if
          else {
            p2Hand.add(newDeck.draw());
          } //end of else
        } //end of for 

        //c) flip method
        for (int c = 1; c < 27; c++) {
          System.out.println("---------------");
          System.out.println("*Round " + c + "*\n");
          Card card1 = playerOne.flip();
          System.out.println("Player 1: " + playerOne.getName());
          card1.describeCard();
          Card card2 = playerTwo.flip();
          System.out.println("Player 2: " + playerTwo.getName());
          card2.describeCard();
         //d) compare value & increment score method on highest value card
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
          } //end of if-else statements
        } //end of for loop
        
        //e) compare final score & f) print final score
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

      } //end of if statement for want to play a game 
      else if (input.equals("n") || input.equals("N")) {
        System.out.println("Goodbye!");
        break;
      } else {
        System.out.println("Sorry, that was not a valid entry.");
      } //end of if-else statement
    } //end of while loop
    //closes scanner
    usrChoice.close();
    
  } //end of main METHOD
} //end of CLASS
