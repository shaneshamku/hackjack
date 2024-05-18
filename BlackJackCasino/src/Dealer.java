public class Dealer {
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void clearHand() {
        hand = new Hand();
    }
}