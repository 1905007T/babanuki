package se.t1905007.card.entity;

public class Main {
	
	
	public static void main(String[] args) {
		CardDeck cd = new CardDeck();
		System.out.println("== 1. フルデッキを作ります．==");
		cd.createFullDeck();
		System.out.println("== ジョーカーも追加します．==");
		Card j = new Card(-1, 0);
		cd.addCard(j);
		System.out.println("== 2. シャッフルします．==");
		cd.shuffle();
		cd.showAllCards();
		
		System.out.println("== 3. 上から何枚か取ってみます．");
		for (int i = 0; i < 3; i++) {
			Card c = cd.takeCard();
			System.out.println(Card.getString(c.getSuit(), c.getNumber()));
		}
		System.out.println("現在のデッキの枚数は，" + cd.size() + "枚です．");
		Card c = cd.seeCard(3);
		System.out.println("上から3番目のカードは，" + Card.getString(c.getSuit(), c.getNumber()) + "です．");
		cd.showAllCards();
	}

}
