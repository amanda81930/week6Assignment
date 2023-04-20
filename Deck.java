package JavaFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Deck {

  // fields
  List<Card> cardsList = new ArrayList<>();

  // constructor
  Deck() { // start of Deck Constructor, no parameters
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    // names of suits in a standard deck in alphabetical order
    String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    // numbers in text form in numerical value order
    //      write enhanced for loop to create our cards
    for (String suit : suits) { // start of enhanced for loop
      int count = 2; // sets the value of the counter starting at 2 through 14
      for (String number : numbers) { // nested enhanced for loop
        Card card = new Card(number, suit, count);
        // instantiate a new card for each card we want to create
        this.cardsList.add(card);
        // puts newly constructed/instantiated card into the cardsList field
        count++;
        // increments our count
      } // end of nested for loop
    } // end of for loop
  } // end of constructor



  // 1. shuffle (randomizes the order of the cards)
  public void shuffle() {
    Collections.shuffle(this.cardsList);
  } // END OF SHUFFLE METHOD

  // 2. draw (removes and returns the top card of the Cards field)
  public Card draw() {
    Card card = this.cardsList.remove(0); // takes top card from deck and points to variable
    return card; // return w/ card
  } // end of DRAW METHOD

 

} // end of Deck CLASS
