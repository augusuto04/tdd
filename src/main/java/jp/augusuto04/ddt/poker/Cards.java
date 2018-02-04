package jp.augusuto04.ddt.poker;

import java.util.StringJoiner;

/**
 * Holds multiple cards.
 * @author shin
 */
public abstract class Cards implements Comparable<Cards> {

    /** Cards of this hand */
    private final Card[] cards;

    /**
     * Constructor.
     * @param cards
     */
    protected Cards(final Card... cards) {
        this.cards = cards;
    }

    /**
     * Get cards.
     * @return
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Get the card of the index.
     * @param index
     * @return
     */
    public final Card getCard(final int index) {
        if (isIllegalIndex(index)) {
            throw new IllegalArgumentException();
        }
        return cards[index];
    }

    /**
     * Compare if the cards have the same rank.
     * @param index1
     * @param index2
     * @return
     */
    public final boolean hasSameRank(final int index1, final int index2) {
        if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
            throw new IllegalArgumentException();
        }
        return cards[index1].hasSameRank(cards[index2]);
    }

    /**
     * Compare if the cards have the same suit.
     * @param index1
     * @param index2
     * @return
     */
    public final boolean hasSameSuit(final int index1, final int index2) {
        if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
            throw new IllegalArgumentException();
        }
        return cards[index1].hasSameSuit(cards[index2]);
    }

    /**
     * Evaluate the hand.
     * @return
     */
    public abstract PokerHand evalHand();

    /**
     * Get the notion of all the cards joined by a white line.
     * @return
     */
    public final String getNotion() {
        StringJoiner sj = new StringJoiner(" ");
        for (Card card : cards) {
            sj.add(card.getNotion());
        }
        return sj.toString();
    }

    /**
     * Checks if the index is in the
     * range of the cards this class holds.
     * @param index
     * @return
     */
    private final boolean isIllegalIndex(final int index) {
        return index < 0 || index >= cards.length;
    }
}
