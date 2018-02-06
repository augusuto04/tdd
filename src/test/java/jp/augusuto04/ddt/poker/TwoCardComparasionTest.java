package jp.augusuto04.ddt.poker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import jp.augusuto04.ddt.poker.cards.TwoCards;

public class TwoCardComparasionTest {

    public void basic1() {
        TwoCards straightFlush = new TwoCards(
                new Card(Suit.CLUB, 5), new Card(Suit.CLUB, 6));
        TwoCards highCard = new TwoCards(
                new Card(Suit.CLUB, 5), new Card(Suit.HEART, 11));

        assertThat(straightFlush.compareTo(highCard) > 0, is(true));
    }

    public void basic2() {
        TwoCards flush = new TwoCards(
                new Card(Suit.CLUB, 9), new Card(Suit.CLUB, 6));
        TwoCards straight = new TwoCards(
                new Card(Suit.CLUB, 10), new Card(Suit.HEART, 11));

        assertThat(straight.compareTo(flush) > 0, is(false));
    }

    public void basic3() {
        TwoCards pair = new TwoCards(
                new Card(Suit.DIAMOND, 6), new Card(Suit.CLUB, 6));
        TwoCards highCard = new TwoCards(
                new Card(Suit.CLUB, 5), new Card(Suit.HEART, 11));

        assertThat(pair.compareTo(highCard) > 0, is(true));
    }
}
