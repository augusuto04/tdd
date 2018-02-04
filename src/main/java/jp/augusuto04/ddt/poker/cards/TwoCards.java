package jp.augusuto04.ddt.poker.cards;

import jp.augusuto04.ddt.poker.Card;
import jp.augusuto04.ddt.poker.Cards;
import jp.augusuto04.ddt.poker.PokerHand;

public class TwoCards extends Cards {

	public TwoCards(Card firstCard, Card secondCard) {
		super(firstCard, secondCard);
	}

	@Override
	public PokerHand evalHand() {
		return PokerHand.evaluateHand(this);
	}

	public boolean isRankConsecutive() {
		return Math.abs(CARDS[0].getRank() - CARDS[1].getRank()) == 1;
	}

	private class TwoCardHandValue {
		private PokerHand hand;
		private Card[] cards;
	}

	@Override
	public int compareTo(Cards o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
