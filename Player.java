package JavaFinal;

import java.util.ArrayList;
import java.util.List;

public class Player {

  // fields
  String name;
  int score; // 2. score (set to 0 in the constructor)

  // 1. hand (List of Card)
  List<Card> hand = new ArrayList<>();

  // constructor
  Player(String name, List<Card> hand) {
    this.name = name;
    this.score = 0;
    this.hand = hand;
  } // end of constructor

  public String getName () {
    return name;
}

public int getScore () {
    return score;
}

public void draw (Deck cards) {
  Card newCard = cards.draw();
  this.hand.add(newCard);
} // draw METHOD

void describeHand() {
  for (Card card : hand) {
    card.describeCard();
  } // end of for loop
} // end of describeHand Method

// flip METHOD
public Card flip() {
  if (this.hand.size() > 0) {
    Card flipCard = this.hand.get(0);
    this.hand.remove(0);
    return flipCard;
  } else {
    return null;
  } //end of if-else statement
} //end of flip METHOD

  // incrementScore METHOD
  public void incrementScore() {
    this.score += 1;
  } //end of incrementScore METHOD

} //end of PLAYER CLASS
