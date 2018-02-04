package jp.augusuto04.ddt.poker;

import jp.augusuto04.ddt.poker.cards.TwoCards;

/**
 * Hands of poker.
 * @author shin
 */
public enum PokerHand {
    /** straight flush. */
    STRAIGHT_FLUSH,
    /** flush. */
    FLUSH,
    /** straight. */
    STRAIGHT,
    /** pair. */
    PAIR,
    /** high card. */
    HIGH_CARD;

    /**
     * Evaluate the hand for two card poker.
     * @param cards cards to evaluate
     * @return evaluation
     */
    public static final PokerHand evaluateHand(final TwoCards cards) {
        if (cards.hasSameSuit(0, 1) && cards.isRankConsecutive()) {
            return STRAIGHT_FLUSH;
        } else if (cards.hasSameSuit(0, 1)) {
            return FLUSH;
        } else if (cards.isRankConsecutive()) {
            return STRAIGHT;
        } else if (cards.hasSameRank(0, 1)) {
            return PAIR;
        } else {
            return HIGH_CARD;
        }
    }
}
