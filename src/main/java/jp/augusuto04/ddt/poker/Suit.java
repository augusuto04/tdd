package jp.augusuto04.ddt.poker;

/**
 * Suit of a card.
 * @author shin
 */
public enum Suit {
    /** spade. */
    SPADE("s"),
    /** club. */
    CLUB("c"),
    /** heart. */
    HEART("h︎"),
    /** diamond. */
    DIAMOND("d︎");

    /** The notion of the suit. */
    private String notion;

    /**
     * Constructor.
     * @param notion notion
     */
    Suit(final String notion) {
        this.notion = notion;
    }

    /**
     * Get the notion of the suit.
     * @return notion
     */
    public String getNotion() {
        return notion;
    }
}
