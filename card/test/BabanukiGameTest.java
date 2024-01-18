package se.t1905007.card.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import se.t1905007.card.entity.CardDeck;
import se.t1905007.card.entity.Player;
import se.t1905007.card.entity.User;
import se.t1905007.card.game.BabanukiGame;

public class BabanukiGameTest extends TestCase {

	private List<Player> players;
	private User player, player1;
	private BabanukiGame babanukigame= new BabanukiGame();
	private CardDeck hand = new CardDeck();
	
	protected void setUp() throws Exception {
		super.setUp();
		player=new User("ババ抜き");
		player.first();
		babanukigame.addPlayer(player);
		player1=new User("ババ抜き１");
		player1.setHand(hand);
		babanukigame.addPlayer(player1);
		babanukigame.getPlayers().get(1).getHand().createFullDeck();
		players=new ArrayList<Player>();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddPlayer() {
		players.add(player);
		assertEquals("ババ抜き", players.get(0).getName());
	}

	public void testDiscardCard() {
		babanukigame.discardCard(player1);
		player1.showHand();
	}

	public void testShowAllRecords() {
		players.add(player);
		System.out.println("-------- 総合成績 ---------");
		System.out.printf("＃ババ抜きさんの対戦成績：1位1回，2位0回，3位0回\n");
		System.out.printf("＃ババ抜き1さんの対戦成績：1位0回，2位0回，3位0回\n");
		babanukigame.showAllRecords();
	}

}
