package jp.augusuto04.ddt.poker.cards;

import jp.augusuto04.ddt.poker.Card;
import jp.augusuto04.ddt.poker.Cards;
import jp.augusuto04.ddt.poker.HandValue;
import jp.augusuto04.ddt.poker.PokerHand;

/**
 * Two cards.
 * @author shin
 */
public class TwoCards extends Cards {

    private final TwoCardHandValue handValue;

    /**
     * Constructor.
     * @param firstCard first card
     * @param secondCard second card
     */
    public TwoCards(final Card firstCard, final Card secondCard) {
        super(firstCard, secondCard);
        handValue = new TwoCardHandValue(this);
    }

    /**
     * Get the evaluation of this hand.
     */
    @Override
    public final PokerHand evalHand() {
        return handValue.getHand();
    }

    /**
     * Evaluates if two cards are consecutive.
     * @return ture if the cards are consecutive
     */
    public final boolean isRankConsecutive() {
        return Math.abs(getCard(0).getRank() - getCard(1).getRank()) == 1;
    }

    /**
     * Hand value of two card hand.
     * @author shin
     */
    private class TwoCardHandValue extends HandValue {

        /**
         * Constructor.
         * @param twoCards hand
         */
        public TwoCardHandValue(final TwoCards twoCards) {
            if (twoCards.isRankConsecutive() && twoCards.hasSameSuit(0, 1)) {
                setHand(PokerHand.STRAIGHT_FLUSH);
            } else if (twoCards.hasSameSuit(0, 1)) {
                setHand(PokerHand.FLUSH);
            } else if (twoCards.isRankConsecutive()) {
                setHand(PokerHand.STRAIGHT);
            } else if (twoCards.hasSameRank(0, 1)) {
                setHand(PokerHand.PAIR);
            } else {
                setHand(PokerHand.HIGH_CARD);
            }
        }
    }

    /**
     * Compare the strength of two hands.
     * @param twoCards two card hand to compare
     * @return compared result
     */
    public final int compareTo(final TwoCards twoCards) {
        return handValue.compareTo(new TwoCardHandValue(twoCards));
    }
}
