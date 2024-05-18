import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;
        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
