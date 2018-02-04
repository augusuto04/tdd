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
    public TwoCards(Card firstCard, Card secondCard) {
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

    private class TwoCardHandValue {
        private PokerHand hand;
        private Card[] cards;
    }

    @Override
    public final int compareTo(Cards o) {
        return 0;
    }
}
