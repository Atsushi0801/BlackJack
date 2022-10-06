package com.design_shinbi.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in)
		); 
		start(reader);
		reader.close();
	}

	public static void start(BufferedReader reader) throws IOException {
		Player player = new Player(reader) ;
		Dealer dealer = new Dealer () ;
		Stock stock = new Stock();
		
		player.start(stock);
		dealer.start(stock);
		
		dealer.display();
		
		player.play(stock);
		dealer.play(stock);
		showResult(player,dealer);
	}

	public static void showResult(Attender player, Attender dealer) {
		dealer.display();
		player.display();
		
		int dealerStrength = dealer.calculateStrength();
		int playerStrength = player.calculateStrength();
		
		if(playerStrength > dealerStrength) {
			System.out.println("あなたの勝ちです");
		}
		else if (playerStrength < dealerStrength) {
			System.out.println("あなたの負けです");
			
		}else  {
			System.out.println("引き分けです");
		
		}
	}
}

