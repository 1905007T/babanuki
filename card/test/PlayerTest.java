package se.t1905007.card.test;

import junit.framework.TestCase;
import se.t1905007.card.entity.Card;
import se.t1905007.card.entity.CardDeck;
import se.t1905007.card.entity.User;

public class PlayerTest extends TestCase {
	private Card card;
	private CardDeck hand;
	private User user, user2;

	protected void setUp() throws Exception {
		user = new User("ババ抜き");
		user2 = new User("ババ抜き２");
		card = new Card(0, 1);
		hand = new CardDeck();
		hand.addCard(card);
		user.setHand(hand);
		user.first();
		user.second();
		user.third();
		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShowHand() {
		System.out.println("------------現在の全てのカードを表示します．-----------");
		System.out.println("1番目のカード：" + card.toString());
		System.out.println("------------ここまで-----------");
		user.showHand();

	}

	public void testShowRecord() {
		System.out.printf("＃ババ抜きさんの対戦成績：1位1回，2位1回，3位1回\n");
		user.showRecord();
	}

	public void testGetName() {
		assertEquals("ババ抜き", user.getName());
	}

	public void testGetHand() {
		System.out.println("------------現在の全てのカードを表示します．-----------");
		System.out.println("1番目のカード：" + card.toString());
		System.out.println("------------ここまで-----------");
		user.getHand().showAllCards();
	}

	public void testGetRecord() {
		assertEquals(1, user.getRecord().getFirst());
	}

	public void testSetHand() {
		user2.setHand(hand);
		card.toString();
		user2.getHand().seeCard(1);
	}

	public void testFirst() {
		assertEquals(1, user.getRecord().getFirst());
	}

	public void testSecond() {
		assertEquals(1, user.getRecord().getSecond());
	}

	public void testThird() {
		assertEquals(1, user.getRecord().getThird());
	}

}
