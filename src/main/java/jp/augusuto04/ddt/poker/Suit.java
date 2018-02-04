package jp.augusuto04.ddt.poker;

/**
 * Suit of a card.
 * @author shin
 */
public enum Suit {
    SPADE("s"),
    CLUB("c"),
    HEART("h︎"),
    DIAMOND("d︎");

    /** The notion of the suit. */
    private String notion;

    /**
     * Constructor.
     * @param notion
     */
    Suit (String notion) {
        this.notion = notion;
    }

    /**
     * Get the notion of the suit.
     * @return
     */
    public String getNotion() {
        return notion;
    }
}
