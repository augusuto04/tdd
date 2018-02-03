package jp.augusuto04.ddt.poker;

import java.util.StringJoiner;

public abstract class Cards implements Comparable<Cards> {

	/** Cards of this hand */
	protected final Card[] CARDS;
	
	protected Cards(Card... cards) {
		CARDS = cards;
	}
	
	public Card getCard(int index) {
		if (isIllegalIndex(index)) {
			throw new IllegalArgumentException();
		}
		return CARDS[index];
	}
	
	public boolean hasSameRank(int index1, int index2) {
		if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
			throw new IllegalArgumentException();
		}
		return CARDS[index1].hasSameRank(CARDS[index2]);
	}
	
	public boolean hasSameSuit(int index1, int index2) {
		if (isIllegalIndex(index1) || isIllegalIndex(index2)) {
			throw new IllegalArgumentException();
		}
		return CARDS[index1].hasSameSuit(CARDS[index2]);
	}
	
	public abstract PokerHand evalHand();
	
	public String getNotion() {
		StringJoiner sj = new StringJoiner(" ");
		for (Card card : CARDS) {
			sj.add(card.getNotion());
		}
		return sj.toString();
	}
	
	private boolean isIllegalIndex(int index) {
		return index < 0 || index >= CARDS.length;
	}
}
