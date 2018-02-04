package jp.augusuto04.ddt.poker;

public enum Suit {
	SPADE("s"),
	CLUB("c"),
	HEART("h︎"),
	DIAMOND("d︎");

	private String notion;

	Suit (String notion) {
		this.notion = notion;
	}

	public String getNotion() {
		return notion;
	}
}
