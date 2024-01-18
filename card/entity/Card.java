package se.t1905007.card.entity;

/**
 * Cardクラス．　絵柄，数字を持つ．
 * @author Ryusei
 *
 */
public class Card {
	/** 絵柄 */
	private int suit;
	/** 数字 */
	private int number;

	/**
	 * 絵柄，数字を指定して、カードインスタンスを作成する．
	 * @param suit
	 * 				絵柄
	 * @param number
	 * 				数字
	 */
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	/**
	 * 絵柄を外部から取得する．
	 * @return
	 * 			絵柄
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * 数字を外部から取得する．
	 * @return
	 * 			数字
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * カードを整数表現に変換する．
	 * @return
	 * 			整数表現
	 */
	public int toIndex() {
		if (suit == -1)
			return -1;
		else
			return suit * 13 + number - 1;
	}

	/**
	 * カードを文字列表現に変換する．
	 * @return
	 * 			文字列表現
	 */
	public String toString() {
		String n;
		switch (number) {
		case 1:
			n = "A";
			break;
		case 11:
			n = "J";
			break;
		case 12:
			n = "Q";
			break;
		case 13:
			n = "K";
			break;
		default:
			n = Integer.toString(number);
		}
		String s = "";
		switch (suit) {
		case 0:
			s = "スペード" + n;
			break;
		case 1:
			s = "ダイヤ" + n;
			break;
		case 2:
			s = "ハート" + n;
			break;
		case 3:
			s = "クラブ" + n;
			break;
		case -1:
			s = "ジョーカー";
			break;
		}
		return s;
	}

	/**
	 * カード情報を画面に出力する
	 */
	public void show() {
		System.out.println(toString());
	}

	/**
	 * 絵柄（0-3）と数字（1-13）を与えると，対応するカードの整数表現を返す
	 * @param suit
	 * 				絵柄
	 * @param number
	 * 				数字
	 * @return
	 * 				整数表現
	 */
	public static int getIndex(int suit, int number) {
		Card c = new Card(suit, number);
		return c.toIndex();
	}

	/**
	 * 絵柄（0-3）と数字（1-13）を与えると，対応するカードの文字列表現を返す
	 * @param suit
	 * 				絵柄
	 * @param number
	 * 				数字
	 * @return
	 * 				文字列表現
	 */
	public static String getString(int suit, int number) {
		Card c = new Card(suit, number);
		return c.toString();
	}

}
