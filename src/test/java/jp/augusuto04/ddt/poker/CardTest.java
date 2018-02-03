package jp.augusuto04.ddt.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CardTest {

	@Test
	public void constructor() {
		
		Card sixOfSpade = new Card(Suit.SPADE, 6);
		assertThat(sixOfSpade.getNotion(), is("6s"));
		
		Card aceOfHeart = new Card(Suit.HEART, "A");
		assertThat(aceOfHeart.getNotion(), is("Ah︎"));
		
		Card sixOfHeart = new Card(Suit.HEART, "6");
		assertThat(sixOfHeart.getNotion(), is("6h︎"));
		
		assertThat(sixOfSpade.hasSameRank(aceOfHeart), is(false));
		assertThat(sixOfSpade.hasSameSuit(aceOfHeart), is(false));
		assertThat(sixOfSpade.hasSameRank(sixOfHeart), is(true));
		assertThat(sixOfSpade.hasSameSuit(sixOfHeart), is(false));
		assertThat(aceOfHeart.hasSameRank(sixOfHeart), is(false));
		assertThat(aceOfHeart.hasSameSuit(sixOfHeart), is(true));
	}
}
