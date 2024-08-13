
package cardgame;


import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aces =0;

       for (Card card : hand) {
    value += card.getValue();
    if (card.getRank().equals("A")) {
        aces++;
       }
    }
       while (value > 21 && aces > 0) {
    value -= 10;
    aces--;
   }

        return value;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    
    public String toString() {
        return name + "'s hand: " + hand.toString() + " (value: " + getHandValue() + ")";
    }
}