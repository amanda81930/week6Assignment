package JavaFinal;

import java.util.HashMap;

public class Card {

  // fields/properties
  String name;
  String suit;
  int value;
  HashMap<String, String> cardSuits = new HashMap<>();

  // Constructor
  public Card(String name, String suit, int value) {
    this.name = name;
    this.suit = suit;
    this.value = value;
  } //end of Card constructor

  // Getters & Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSuit() {
    return suit;
  }

  public void setSuit(String suit) {
    this.suit = suit;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }


  // DescribeCard method
  public void describeCard() {
    cardSuits.put("Spades", "\u2660");
    cardSuits.put("Clubs", "\u2663");
    cardSuits.put("Hearts", "\u2665");
    cardSuits.put("Diamonds", "\u2666");
    System.out
        .println("\t" + this.name + " of " + cardSuits.get(this.suit) + " [" + this.value + "]");
  } //end of describeCard M


} // END OF CARD CLASS

