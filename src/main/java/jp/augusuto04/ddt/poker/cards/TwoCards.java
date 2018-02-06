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
        public TwoCardHandValue(final TwoCards twoCards) {

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
