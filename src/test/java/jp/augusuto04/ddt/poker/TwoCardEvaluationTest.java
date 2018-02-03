package jp.augusuto04.ddt.poker;

import org.junit.Test;

import jp.augusuto04.ddt.poker.cards.TwoCards;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TwoCardEvaluationTest {

	@Test
	public void evalHighCard() {
		
		TwoCards hand = new TwoCards(new Card(Suit.CLUB, 3), 
				                     new Card(Suit.DIAMOND, 5));
		
		assertThat(hand.evalHand(), is(PokerHand.HIGH_CARD));
	}
	
	@Test
	public void evalPair() {
		
		TwoCards hand = new TwoCards(new Card(Suit.CLUB, 5), 
				                     new Card(Suit.DIAMOND, 5));
		
		assertThat(hand.evalHand(), is(PokerHand.PAIR));
	}
	
	@Test
	public void evalFlush() {
		
		TwoCards hand = new TwoCards(new Card(Suit.CLUB, 3), 
				                     new Card(Suit.CLUB, 5));
		
		assertThat(hand.evalHand(), is(PokerHand.FLUSH));
	}
	
	@Test
	public void evalStraightFlush() {
		
		TwoCards hand = new TwoCards(new Card(Suit.CLUB, 4),
				                     new Card(Suit.CLUB, 5));
		
		assertThat(hand.evalHand(), is(PokerHand.STRAIGHT_FLUSH));
	}
	
	@Test
	public void evalStraight() {
		
		TwoCards hand = new TwoCards(new Card(Suit.SPADE, 10),
									 new Card(Suit.DIAMOND, 11));
		
		assertThat(hand.evalHand(), is(PokerHand.STRAIGHT));
	}
}
