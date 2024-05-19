import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game() {
        deck = new Deck();
        player = new Player("Player", 1000);
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Blackjack!");
        while (player.getBalance() > 0) {
            deck.shuffle();
            player.clearHand();
            dealer.clearHand();

            System.out.println("Your balance: " + player.getBalance());
            System.out.print("Place your bet: ");
            double bet = scanner.nextDouble();
            player.placeBet(bet);

            player.getHand().addCard(deck.dealCard());
            player.getHand().addCard(deck.dealCard());
            dealer.getHand().addCard(deck.dealCard());
            dealer.getHand().addCard(deck.dealCard());

            System.out.println("Your hand: " + player.getHand());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [hidden]");
int playerTurn = 1;
            while (playerTurn > 0) {
                System.out.println("Your hand value: " + player.getHand().getHandValue());
                playerTurn = PlayerMove(playerTurn);
                if (player.getHand().getHandValue() > 21) {
                    System.out.println("Bust! You lose.");
                    player.loseBet();
                    playerTurn = -1;
                }
                playerTurn++;
            }

            if (player.getHand().getHandValue() <= 21) {
                while (dealer.getHand().getHandValue() < 17) {
                    dealer.getHand().addCard(deck.dealCard());
                }
                System.out.println("Dealer's hand: " + dealer.getHand());
                if (dealer.getHand().getHandValue() > 21 || dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
                    System.out.println("You win!");
                    player.winBet();
                } else if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
                    System.out.println("Push! It's a tie.");
                    player.pushBet();
                } else {
                    System.out.println("Dealer wins.");
                    player.loseBet();
                }
            }
            
            System.out.print("Do you want to play again? (yes/no) ");
            String again = scanner.next();
            if (!again.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thanks for playing! Your final balance is: " + player.getBalance());
    }

    public int PlayerMove(int playerTurn){
        if(playerTurn == 1){
            System.out.print("Do you want to Hit (1), Stand (2), or double (3)? ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                player.getHand().addCard(deck.dealCard());
                System.out.println("Your hand: " + player.getHand());
            }
            else if(choice == 3){
                player.getHand().addCard(deck.dealCard());
                System.out.println("Your hand: " + player.getHand());
                player.doubleBet();
            }
            else{
                playerTurn = -1;
            }
        }
        else{
            System.out.print("Do you want to Hit (1), or Stand (2)? ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                player.getHand().addCard(deck.dealCard());
                System.out.println("Your hand: " + player.getHand());
            }
            else if(choice == 3){
                player.getHand().addCard(deck.dealCard());
                System.out.println("Your hand: " + player.getHand());
                player.doubleBet();
            }
            else{
                playerTurn = -1;
            }

        }
        return playerTurn;
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}