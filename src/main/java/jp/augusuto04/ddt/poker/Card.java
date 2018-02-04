package jp.augusuto04.ddt.poker;

/**
 * Card.
 * @author shin
 */
public class Card {
    /** The suit of this card. */
    private final Suit suit;

    /** The rank of this card. */
    private final int rank;

    /** Rank of the Ace. */
    private static final int ACE = 1;
    /** Rank of the Ten. */
    private static final int TEN = 10;
    /** Rank of the Jack. */
    private static final int JACK = 11;
    /** Rank of the Queen. */
    private static final int QUEEN = 12;
    /** Rank of the King. */
    private static final int KING = 13;

    /**
     * Constructor.
     * @param suit suit of the card
     * @param rank rank of the card
     */
    public Card(final Suit suit, final int rank) {
        if (rank <= 0 || rank > KING) {
            throw new IllegalArgumentException("");
        }
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Constructor.
     * @param suit suit of the card
     * @param rank rank of the card
     */
    public Card(final Suit suit, final String rank) {
        this.suit = suit;
        this.rank = convertRank(rank);
    }

    /**
     * Convert the string expression of the rank to int.
     * @param rank String expression of the rank
     * @return int expression of the rank
     */
    private static int convertRank(final String rank) {
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
            if (intRank <= 0 || intRank > KING) {
                throw new IllegalArgumentException(
                        "rank was less than 1 or more than 13");
            }
            return intRank;
        }
    }

    /**
     * Get the notion of rank.
     * @param rank rank
     * @return String expression of the rank
     */
    private static String getNotionOfRank(final int rank) {
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
     * @return suit
     */
    public final Suit getSuit() {
        return suit;
    }

    /**
     * Get the rank of this card in int.
     * @return rank
     */
    public final int getRank() {
        return rank;
    }

    /**
     * Get the notion of this card.
     * ex) ace of spades will be As
     * rank will be A, T, J, Q, K or number itself
     * suit will be s, c, h or d
     * @return notion of the card
     */
    public final String getNotion() {
        return getNotionOfRank(rank) + suit.getNotion();
    }

    /**
     * Evaluates if the suit is the same.
     * @param card card to compare
     * @return if the suit is the same
     */
    public final boolean hasSameSuit(final Card card) {
        return suit == card.getSuit();
    }

    /**
     * Evaluates if the rank is the same.
     * @param card card to compare
     * @return if the rank is the same
     */
    public final boolean hasSameRank(final Card card) {
        return rank == card.getRank();
    }
}
