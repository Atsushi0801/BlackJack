package com.design_shinbi.blackjack;

public enum Suit {
	
	SPADE(" ♠ "),
	HEART(" ♥ "),
	DIAMOND(" ♦ "),
	CLUB(" ♣ ");

	private String name;
	private Suit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
