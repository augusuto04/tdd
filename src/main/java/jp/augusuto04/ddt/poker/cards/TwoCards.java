package jp.augusuto04.ddt.poker.cards;

import jp.augusuto04.ddt.poker.Card;
import jp.augusuto04.ddt.poker.Cards;
import jp.augusuto04.ddt.poker.PokerHand;

/**
 * Two cards.
 * @author shin
 */
public class TwoCards extends Cards {

    /**
     * Constructor.
     * @param firstCard first card
     * @param secondCard second card
     */
    public TwoCards(final Card firstCard, final Card secondCard) {
        super(firstCard, secondCard);
    }

    /**
     * Get the evaluation of this hand.
     */
    @Override
    public final PokerHand evalHand() {
        return PokerHand.evaluateHand(this);
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
    private class TwoCardHandValue {
        /** hand. */
        private PokerHand hand;
        /** cards to evaluate then hand is the same. */
        private Card[] cards;
    }

    @Override
    public final int compareTo(final Cards o) {
        return 0;
    }
}
