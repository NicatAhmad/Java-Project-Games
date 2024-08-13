
package cardgame;


public class Card {
    private String suit;  
    private String rank;  

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        
 
        if (rank == "A")
            return 11;
        else if (rank == "K" || rank == "Q" || rank == "J")
            return 10;
        else 
            return Integer.parseInt(rank);  
    }

    
    public String toString() {
        return rank + " of " + suit;
    }
}
