package se.t1905007.card.test;

import junit.framework.TestCase;
import se.t1905007.card.entity.Card;
import se.t1905007.card.entity.CardDeck;

/**
 * トランプゲームのカードデッキクラスのテストクラス
 */
public class CardDeckTest extends TestCase {
	private CardDeck deck1 = new CardDeck();
	private Card spadeA, diamond10, heartQ, clubK, joker;

	/**
	 * 各テストメソッドの実行の前処理
	 */
	protected void setUp() throws Exception {
		super.setUp();
		spadeA = new Card(0, 1); // スペードA
		diamond10 = new Card(1, 10); // ダイヤ10
		heartQ = new Card(2, 12); // ハートQ
		clubK = new Card(3, 13); // クラブK
		joker = new Card(-1, 0); // ジョーカー
	}

	/**
	 * 各テストメソッドの実行の後処理
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateFullDeck() {
		System.out.println("○期待される振る舞い：");
		System.out.println("------------現在の山を表示します．-----------");
		System.out.println(1 + "番目のカード：スペードA");
		for (int i = 2; i <= 10; i++) {
			System.out.println(i + "番目のカード：スペード" + i);
		}
		System.out.println(11 + "番目のカード：スペードJ");
		System.out.println(12 + "番目のカード：スペードQ");
		System.out.println(13 + "番目のカード：スペードK");
		System.out.println(14 + "番目のカード：ダイヤA");
		for (int i = 2; i <= 10; i++) {
			System.out.println((i + 13) + "番目のカード：ダイヤ" + i);
		}
		System.out.println(24 + "番目のカード：ダイヤJ");
		System.out.println(25 + "番目のカード：ダイヤQ");
		System.out.println(26 + "番目のカード：ダイヤK");
		System.out.println(27 + "番目のカード：ハートA");
		for (int i = 2; i <= 10; i++) {
			System.out.println((i + 26) + "番目のカード：ハート" + i);
		}
		System.out.println(37 + "番目のカード：ハートJ");
		System.out.println(38 + "番目のカード：ハートQ");
		System.out.println(39 + "番目のカード：ハートK");
		System.out.println(40 + "番目のカード：クラブA");
		for (int i = 2; i <= 10; i++) {
			System.out.println((i + 39) + "番目のカード：クラブ" + i);
		}
		System.out.println(50 + "番目のカード：クラブJ");
		System.out.println(51 + "番目のカード：クラブQ");
		System.out.println(52 + "番目のカード：クラブK");
		System.out.println("------------ここまで-----------");
		deck1.createFullDeck();
		deck1.showAllCards();
	}

	public void testClear() {
		deck1.clear();
		assertEquals(0, deck1.size());
	}

	public void testShuffle() {
		deck1.shuffle();
		deck1.showAllCards();
	}

	public void testAddCardCard() {
		deck1.addCard(spadeA);
		assertEquals("スペードA", deck1.seeCard(1).toString());
	}

	public void testAddCardIntCard() {
		deck1.createFullDeck();
		deck1.addCard(3, joker);
		assertEquals("ジョーカー", deck1.seeCard(3).toString());
	}

	public void testTakeCard() {
		deck1.addCard(spadeA);
		assertEquals("スペードA", deck1.takeCard().toString());
	}

	public void testTakeCardInt() {
		deck1.createFullDeck();
		deck1.addCard(3, joker);
		assertEquals("ジョーカー", deck1.takeCard(3).toString());
	}

	public void testSeeCard() {
		deck1.createFullDeck();
		deck1.addCard(3, spadeA);
		assertEquals("スペードA", deck1.seeCard(3).toString());
	}

	public void testSearchCard() {
		deck1.createFullDeck();
		deck1.addCard(3, joker);
		assertEquals(3, deck1.searchCard(-1, 0));
	}

	public void testIsEmpty() {
		deck1.clear();
		assertEquals(true, deck1.isEmpty());
	}

	public void testSize() {
		deck1.clear();
		deck1.addCard(spadeA);
		deck1.addCard(diamond10);
		deck1.addCard(heartQ);
		deck1.addCard(clubK);
		assertEquals(4, deck1.size());
	}

	public void testShowAllCards() {
		System.out.println("------------現在の山を表示します．-----------");
		for (int i = 0; i < deck1.size(); i++) {
			System.out.println((i + 1) + "番目のカード：" + deck1.seeCard(i).toString());
		}
		System.out.println("------------ここまで-----------");
		deck1.showAllCards();
	}

}
