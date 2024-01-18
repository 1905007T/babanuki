package se.t1905007.card.entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * CardDeckクラス．
 * @author Ryusei
 *
 */
public class CardDeck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	/**
	 * からのカードデッキインスタンスを作る
	 */
	public CardDeck() {

	}

	/**
	 * カードデッキをフルデッキにする
	 */
	public void createFullDeck() {
		cards.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				Card c = new Card(i, j);
				cards.add(c);
			}
		}
	}

	/**
	 * カードデッキを空デッキにする
	 */
	public void clear() {
		for (int i = 0; i < cards.size(); i++) {
			cards.remove(i);
		}
	}

	/**
	 * カードデッキをシャッフルしてカードの順番を混ぜる
	 */
	public void shuffle() {
		System.out.println("シャッフルします．");
		Collections.shuffle(cards);
	}

	/**
	 * 一番最後に任意のカードを追加する
	 * @param card
	 * 				追加するカード
	 */
	public void addCard(Card card) {
		cards.add(card);
	}

	/**
	 * i番目に、任意のカードを追加する
	 * @param i
	 * 			追加する場所
	 * @param card
	 * 				追加するカード
	 */
	public void addCard(int i, Card card) {
		cards.add(i - 1, card);
	}

	/**
	 * デッキの一番上のカードをとる
	 * @return
	 * 			とったカード
	 */
	public Card takeCard() {
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}

	/**
	 * i番目からカードをとる
	 * @param i
	 * 			カードをとる場所
	 * @return
	 * 			とったカード
	 */
	public Card takeCard(int i) {
		Card c = cards.get(i - 1);
		cards.remove(i - 1);
		return c;
	}

	/**
	 * i番目にあるカードをみる
	 * @param i
	 * 			見るカードの場所
	 * @return
	 * 			見るカード
	 */
	public Card seeCard(int i) {
		Card c = cards.get(i - 1);
		return c;
	}

	/**
	 * 絵柄suitと番号numberを与えて，そのカードがデッキの何番目にあるかを調べる
	 * @param suit
	 * 				絵柄
	 * @param number
	 * 				数字
	 * @return
	 * 				カードの場所
	 */
	public int searchCard(int suit, int number) {

		for (int i = 0; i < cards.size(); i++) {
			if ((cards.get(i).getSuit() == suit) && (cards.get(i).getNumber() == number))
				return cards.indexOf(cards.get(i)) + 1;
		}
		return 0;
	}

	/**
	 * 現在のデッキが空かどうか判定する
	 * @return
	 * 			からかどうか
	 */
	public boolean isEmpty() {
		if (cards.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * デッキにある
	 * カード枚数を返す
	 * @return
	 * 			カード枚数
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * 現在のすべてのカードを画面に表示する
	 */
	public void showAllCards() {
		System.out.println("------------現在の全てのカードを表示します．-----------");
		for (int i = 0; i < cards.size(); i++) {
			System.out.println((i + 1) + "番目のカード：" + cards.get(i).toString());
		}
		System.out.println("------------ここまで-----------");
	}

	/**
	 * 現在デッキにあるすべてのカードを返す
	 * @return
	 * 			デッキ
	 */
	public ArrayList<Card> getAllCards() {
		return cards;
	}
}
