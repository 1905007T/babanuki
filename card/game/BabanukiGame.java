package se.t1905007.card.game;

import java.util.ArrayList;
import java.util.List;

import se.t1905007.card.entity.Card;
import se.t1905007.card.entity.CardDeck;
import se.t1905007.card.entity.Player;
import se.t1905007.card.entity.User;

/**
 * ババ抜きゲームクラス
 * 
 * @author Ryusei
 *
 */
public class BabanukiGame {
	private int numberOfGames; //対戦回数
	private List<Player> players; //全プレイヤ
	private List<Player> playingPlayers; //上がっていないプレイヤのリスト

	/**
	 * じゃんけんゲームを作成する
	 */
	public BabanukiGame() {
		players = new ArrayList<Player>();
		playingPlayers = new ArrayList<Player>();
	}

	/**
	 * プレイヤを追加する
	 * @param player ババ抜きに参加するプレイヤ
	 */
	public void addPlayer(Player player) {
		players.add(player);
		System.out.printf("「%s」さんをゲームに登録しました．\n", player.getName());
	}

	/**
	 * 全プレイヤのリストを取得する
	 * @return 全プレイヤのリスト
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * 全レイヤのリストをセットする
	 * @param players 全プレイヤのリスト
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * 対戦回数をセットする
	 * @param numberOfGames 対戦回数
	 */
	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}

	/**
	 * 対戦回数を取得する
	 * @return 対戦回数
	 */
	public int getNumberOfGames() {
		return numberOfGames;
	}

	/**
	 * 同じ数字のカードが2枚あれば削除する
	 * @param player
	 */
	public void discardCard(Player player) {
		for (int i = 1; i <= player.getHand().size(); i++) {
			for (int j = i + 1; j <= player.getHand().size(); j++) {
				if (player.getHand().seeCard(i).getNumber() == player.getHand().seeCard(j).getNumber()) {
					player.getHand().takeCard(j);
					player.getHand().takeCard(i);
					i = 1;
					j = 1;
				}
			}
		}
	}

	/**
	 * ゲームを開始する．ババ抜きを対戦回数だけ繰り返し，最後に成績を表示する．
	 */
	public void startGame() {
		//パラメータチェック．エラー処理
		if (players.size() < 2) {
			System.out.println("×プレイヤが足りません．ゲームを開始できません");
			return;
		} else if (numberOfGames < 1) {
			System.out.println("×対戦回数は正の整数で指定してください．ゲームを開始できません");
			return;
		}

		System.out.printf("■ババ抜きゲームを開始します．全%d回戦です．\n", numberOfGames);
		for (int k = 1; k <= numberOfGames; k++) {
			System.out.printf("--------------      第%d回戦      --------------\n", k);
			doBabanuki();
		}
		showAllRecords();
	}

	/**
	 * カードを分ける
	 */
	public void divideCard() {

		CardDeck cd = new CardDeck();
		cd.createFullDeck();
		Card j = new Card(-1, 0);
		cd.addCard(j);
		cd.shuffle();
		int n = players.size();

		for (Player p : players) {
			CardDeck hand = new CardDeck();
			p.setHand(hand);
			for (int i = 1; i <= 53 / n; i++) {
				Card c = cd.takeCard();
				p.getHand().addCard(c);
			}
		}

		for (Player p : players) {
			if (cd.size() > 0)
				p.getHand().addCard(cd.takeCard());
		}
	}

	/**
	 * 1回のババ抜きをする
	 */
	public void doBabanuki() {
		int c = 0; //選んだカードの番号

		divideCard(); //手札を分ける
		for (Player p : players) { //ユーザの手札のカードを全て表示
			discardCard(p);
			//System.out.println(p.getName()); //a
			if (p instanceof User) //a
				p.getHand().showAllCards();
		}

		for (Player p : players) {
			playingPlayers.add(p);
		}

		while (playingPlayers.size() > 0) {
			for (int i = 0; i < playingPlayers.size(); i++) {
				if (i == playingPlayers.size() - 1) {
					c = playingPlayers.get(i).chooseCard(playingPlayers.get(0));
				} else {
					c = playingPlayers.get(i).chooseCard(playingPlayers.get(i + 1)); //次の人の手札からカードを選ぶ
				}
				if (playingPlayers.get(i) instanceof User) //ユーザの場合選んだカードを見せる
					playingPlayers.get(i + 1).getHand().seeCard(c).toString();
				if (i == playingPlayers.size() - 1) {
					playingPlayers.get(i).getHand().addCard(playingPlayers.get(0).getHand().takeCard(c)); //カードを渡す

				} else {
					playingPlayers.get(i).getHand().addCard(playingPlayers.get(i + 1).getHand().takeCard(c)); //カードを渡す
				}
				if (i == playingPlayers.size() - 1) {
					if (playingPlayers.get(0).getHand().isEmpty() == true) {//プレイヤが他の人からカードを取られてカードの枚数が0枚になったとき
						if (players.size() - playingPlayers.size() == 0)
							playingPlayers.get(0).first();
						else if (players.size() - playingPlayers.size() == 1)
							playingPlayers.get(0).second();
						else if (players.size() - playingPlayers.size() == 2)
							playingPlayers.get(0).third();
						playingPlayers.remove(0); //上がった人はリストから外す
					}
					if (playingPlayers.size() == 1) {
						if (players.size() - playingPlayers.size() == 0)
							playingPlayers.get(0).first();
						else if (players.size() - playingPlayers.size() == 1)
							playingPlayers.get(0).second();
						else if (players.size() - playingPlayers.size() == 2)
							playingPlayers.get(0).third();
						playingPlayers.remove(0); //上がった人はリストから外す
					}
				} else {
					if (playingPlayers.get(i + 1).getHand().isEmpty() == true) {//プレイヤが他の人からカードを取られてカードの枚数が0枚になったとき
						if (players.size() - playingPlayers.size() == 0)
							playingPlayers.get(i + 1).first();
						else if (players.size() - playingPlayers.size() == 1)
							playingPlayers.get(i + 1).second();
						else if (players.size() - playingPlayers.size() == 2)
							playingPlayers.get(i + 1).third();
						playingPlayers.remove(i + 1); //上がった人はリストから外す
					}
					if (playingPlayers.size() == 1) {
						if (players.size() - playingPlayers.size() == 0)
							playingPlayers.get(0).first();
						else if (players.size() - playingPlayers.size() == 1)
							playingPlayers.get(0).second();
						else if (players.size() - playingPlayers.size() == 2)
							playingPlayers.get(0).third();
						playingPlayers.remove(0); //上がった人はリストから外す
					}
				}
				if (playingPlayers.get(i).getHand().size() >= 2)
					discardCard(playingPlayers.get(i));
				if (playingPlayers.get(i).getHand().isEmpty() == true) {//プレイヤが他の人からカードをとってカードの枚数が0枚になったとき
					if (players.size() - playingPlayers.size() == 0)
						playingPlayers.get(i).first();
					else if (players.size() - playingPlayers.size() == 1)
						playingPlayers.get(i).second();
					else if (players.size() - playingPlayers.size() == 2)
						playingPlayers.get(i).third();
					playingPlayers.remove(i);
				} else {
					if (playingPlayers.get(i) instanceof User)
						playingPlayers.get(i).getHand().showAllCards();
				}
				if (playingPlayers.size() == 1) {
					if (players.size() - playingPlayers.size() == 0)
						playingPlayers.get(0).first();
					else if (players.size() - playingPlayers.size() == 1)
						playingPlayers.get(0).second();
					else if (players.size() - playingPlayers.size() == 2)
						playingPlayers.get(0).third();
					playingPlayers.remove(0); //上がった人はリストから外す
				}
			}
		}
	}

	/**
	 * プレイヤ全員の対戦成績を表示する
	 */
	public void showAllRecords() {
		System.out.println("-------- 総合成績 ---------");
		for (Player p : players) {
			p.showRecord();
		}
	}
}
