public class Player {
    private String name;
    private Hand hand;
    private double balance;
    private double bet;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double bet) {
        if (bet <= balance) {
            this.bet = bet;
            balance -= bet;
        }
    }

    public void winBet() {
        balance += 2 * bet;
    }

    public void loseBet() {
        bet = 0;
    }

    public void pushBet() {
        balance += bet;
    }

    public void clearHand() {
        hand = new Hand();
    }
}