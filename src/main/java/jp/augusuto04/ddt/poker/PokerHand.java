package jp.augusuto04.ddt.poker;

/**
 * Hands of poker.
 * @author shin
 */
public enum PokerHand {
    /** straight flush. */
    STRAIGHT_FLUSH(5),
    /** flush. */
    FLUSH(4),
    /** straight. */
    STRAIGHT(3),
    /** pair. */
    PAIR(2),
    /** high card. */
    HIGH_CARD(1);

    /** the hand value for comparing hand values. */
    private int value;

    /**
     * Constructor.
     * @param value value of hand
     */
    private PokerHand(final int value) {
        this.value = value;
    }

    /**
     * Get the value of the hand.
     * @return value
     */
    public final int getValue() {
        return value;
    }

}
