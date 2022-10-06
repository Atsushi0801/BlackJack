package com.design_shinbi.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Attender {
	protected List<Card> cards;
	protected String name;

	public Attender(String name) {
		this.name = name;
		initialize();
		//名前を取得する
	}

	public void initialize() {
		this.cards = new ArrayList<Card>();
		//山札シャッフル
		}
	

	public void start(Stock stock) {
		this.cards.clear();
		for(int i = 0; i<2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
		//開始・手札を２枚引く
	}

	public String getName() {
		return name;
	}

	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
		//手札を１枚引く
	}

	public static int calculateStrengthFromList(List<Card> list) {
		int strength = 0;
		boolean hasAce = false; //エースをもっているかどうか
		
		for(Card card : list) {
			if(card.getNumber() == 1) {
				strength += 1;
				hasAce = true;
			}
			else if(card.getNumber() > 10) {
				strength += 10;
			}
			else {
				strength += card.getNumber();
			}
		}
		
		if(hasAce && strength + 10 <= 21) {
			strength += 10;     // A: 1 ではなく 11 として扱う
		}
		
		if(strength > 21) {
			strength = 0;
		}
		
		return strength;
	}
		//手札の強さを計算する
	
	public int calculateStrength() {
		int strength = calculateStrengthFromList(this.cards);
		return strength;
	}

	public String toString() {
		String string = name + ": ";
		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public abstract void play(Stock stock) throws IOException;
}
