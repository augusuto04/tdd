package jp.augusuto04.ddt.poker;

public abstract class HandValue {
    /** hand. */
    private PokerHand hand;
    /** cards to evaluate then hand is the same. */
    private Card[] cards;

    /**
     * Get the hand.
     * @return hand
     */
    public final PokerHand getHand() {
        return hand;
    }

    /**
     * Get the cards.
     * @return cards
     */
    public final Card[] getCards() {
        return cards;
    }

    /**
     * Compare the strength of the two hands.
     * @param handvalue hand to compare
     * @return -1, 0, 1 if handvalue has more, same, less value
     */
    public final int compareTo(final HandValue handvalue) {
        if (hand.getValue() == handvalue.getHand().getValue()) {
            for (int i = 0; i < cards.length; i++) {
                int comparedResult = cards[i].compareRankStrength(handvalue.getCards()[i]);
                if (comparedResult != 0) {
                    return comparedResult;
                }
            }
        } else if (hand.getValue() < handvalue.getHand().getValue()) {
            return -1;
        } else {
            return 1;
        }
        return 0;
    }
}
