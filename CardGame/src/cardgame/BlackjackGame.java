
package cardgame;


import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

     
        player.addCardToHand(deck.dealCard());
        player.addCardToHand(deck.dealCard());

        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        System.out.println(player.toString());
        System.out.println("Dealer's first card: " + dealer.getHand().get(0));

      
        while (true) {
            System.out.print("Do you want to 'hit' or 'stand'? ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit")) {
                player.addCardToHand(deck.dealCard());
                System.out.println(player.toString());

                if (player.getHandValue() > 21) {
                    System.out.println("Busted! You lose.");
                    return;
                }
            } else if (action.equalsIgnoreCase("stand")) {
                break;
            } else {
                System.out.println("Invalid action. Please enter 'hit' or 'stand'.");
            }
        }

        
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(deck.dealCard());
            System.out.println("Dealer's hand: " + dealer);
        }

      
        if (dealer.getHandValue() > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (dealer.getHandValue() > player.getHandValue()) {
            System.out.println("Dealer win!");
        } else if (dealer.getHandValue() < player.getHandValue()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    }
}