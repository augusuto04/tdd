package jp.augusuto04.ddt.poker;

public class Card {
	private final Suit suit;
	private final int rank;

	private static final int ACE = 1;
	private static final int TEN = 10;
	private static final int JACK = 11;
	private static final int QUEEN = 12;
	private static final int KING = 13;

	/**
	 * Constructor.
	 * @param suit
	 * @param rank
	 */
	public Card(Suit suit, int rank) {
		if (rank <= 0 || rank > KING) {
			throw new IllegalArgumentException("");
		}
		this.suit = suit;
		this.rank = rank;
	}

	public Card(Suit suit, String rank) {
		this.suit = suit;
		this.rank = convertRank(rank);
	}

	private static int convertRank(String rank) {
		switch (rank) {
		case "A":
			return ACE;
		case "T":
			return TEN;
		case "J":
			return JACK;
		case "Q":
			return QUEEN;
		case "K":
			return KING;
		default:
			int intRank = Integer.valueOf(rank);
			if (intRank <= 0 || intRank > 13) {
				throw new IllegalArgumentException(
						"rank was less than 1 or more than 13");
			}
			return intRank;
		}
	}

	private static String getNotionOfRank(int rank) {
		switch (rank) {
		case ACE:
			return "A";
		case TEN:
			return "T";
		case JACK:
			return "J";
		case QUEEN:
			return "Q";
		case KING:
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
		return suit;
	}

	/**
	 * Get the rank of this card in int.
	 * @return
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Get the notion of this card.
	 * ex) ace of spades will be As
	 * rank will be A, T, J, Q, K or number itself
	 * suit will be s, c, h or d
	 * @return
	 */
	public String getNotion() {
		return getNotionOfRank(rank) + suit.getNotion();
	}

	public boolean hasSameSuit(Card card) {
		return suit == card.getSuit();
	}

	public boolean hasSameRank(Card card) {
		return rank == card.getRank();
	}
}
