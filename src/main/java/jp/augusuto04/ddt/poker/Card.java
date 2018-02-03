package jp.augusuto04.ddt.poker;

public class Card {
	private final Suit SUIT;
	private final int RANK;

	/**
	 * Constructor.
	 * @param suit
	 * @param rank
	 */
	public Card(Suit suit, int rank) {
		if (rank <= 0 || rank > 13) {
			throw new IllegalArgumentException("");
		}
		SUIT = suit;
		RANK = rank;
	}
	
	public Card(Suit suit, String rank) {
		SUIT = suit;
		RANK = convertRank(rank);
	}
	
	private static int convertRank(String rank) {
		switch(rank) {
		case "A":
			return 1;
		case "T":
			return 10;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			int intRank = Integer.valueOf(rank);
			if (intRank <= 0 || intRank > 13) {
				throw new IllegalArgumentException("rank was less than 1 or more than 13");
			}
			return intRank;
		}
	}
	
	private static String getNotionOfRank(int rank) {
		switch(rank) {
		case 1:
			return "A";
		case 10:
			return "T";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			return String.valueOf(rank);
		}
	}
	
	/**
	 * Get the suit of this card.
	 * @return
	 */
	public Suit getSuit() {
		return SUIT;
	}
	
	/**
	 * Get the rank of this card in int.
	 * @return
	 */
	public int getRank() {
		return RANK;
	}
	
	/**
	 * Get the notion of this card.
	 * ex) ace of spades will be As
	 * rank will be A, T, J, Q, K or number itself
	 * suit will be s, c, h or d
	 * @return
	 */
	public String getNotion() {
		return getNotionOfRank(RANK) + SUIT.getNotion();
	}
	
	public boolean hasSameSuit(Card card) {
		return SUIT == card.getSuit();
	}
	
	public boolean hasSameRank(Card card) {
		return RANK == card.getRank();
	}
}
