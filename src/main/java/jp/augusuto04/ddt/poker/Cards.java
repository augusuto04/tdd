package jp.augusuto04.ddt.poker;

import java.util.StringJoiner;

/**
 * Holds multiple cards.
 * @author shin
 */
public abstract class Cards implements Comparable<Cards> {

    /** Cards of this hand */
    protected final Card[] CARDS;

    /**
     * Constructor.
     * @param cards
     */
    protected Cards(Card... cards) {
        CARDS = cards;
    }

    /**
     * Get the card of the index.
     * @param index
     * @return
     */
    public Card getCard(int index) {
        if (isIllegalIndex(index)) {
            throw new IllegalArgumentException();
        }
        return CARDS[index];
    }

    /**
     * Compare if the cards have the same rank.
     * @param index1
     * @param index2
     * @return
     */
    public boolean hasSameRank(int index1, int index2) {
        if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
    	    throw new IllegalArgumentException();
    	}
    	return CARDS[index1].hasSameRank(CARDS[index2]);
    }

    /**
     * Compare if the cards have the same suit.
     * @param index1
     * @param index2
     * @return
     */
    public boolean hasSameSuit(int index1, int index2) {
    	if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
    	    throw new IllegalArgumentException();
    	}
    	return CARDS[index1].hasSameSuit(CARDS[index2]);
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
    public String getNotion() {
    	StringJoiner sj = new StringJoiner(" ");
    	for (Card card : CARDS) {
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
    private boolean isIllegalIndex(int index) {
        return index < 0 || index >= CARDS.length;
    }
}
