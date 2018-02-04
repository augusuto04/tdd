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
     * @param cards cards
     */
    protected Cards(final Card... cards) {
        this.cards = cards;
    }

    /**
     * Get cards.
     * @return cards
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Get the card of the index.
     * @param index index of the card to get
     * @return card of the index
     */
    public final Card getCard(final int index) {
        if (isIllegalIndex(index)) {
            throw new IllegalArgumentException();
        }
        return cards[index];
    }

    /**
     * Compare if the cards have the same rank.
     * @param index1 index of card to compare
     * @param index2 index of card to compare
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
     * @param index1 index of card to compare
     * @param index2 index of card to compare
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
     * @return evaluation of card
     */
    public abstract PokerHand evalHand();

    /**
     * Get the notion of all the cards joined by a white line.
     * @return notion
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
     * @param index index of the card to check
     * @return if the index is legal
     */
    private boolean isIllegalIndex(final int index) {
        return index < 0 || index >= cards.length;
    }
}
