package se.t1905007.card.entity;

/**
 * ババ抜きのプレーヤクラス
 * 
 * @author Ryusei
 *
 */
public abstract class Player {
	protected String name;
	protected CardDeck hand;
	protected Record record;

	/**
	 * 名前を指定してプレイヤを作成する
	 * @param name 名前
	 */
	public Player(String name) {
		if (name.length() == 0 || name == null) {
			this.name = "名無し";
		} else {
			this.name = name;
		}
		record = new Record();
	}

	/**
	 * プレイヤが取るカードを選ぶ．具体的な選び方はサブクラスに任せる
	 */
	public abstract int chooseCard(Player player);

	/**
	 * プレイヤの手札を画面に表示する
	 */
	public void showHand() {
		hand.showAllCards();
	}

	/**
	 * プレイヤの対戦成績を画面に表示する
	 */
	public void showRecord() {
		System.out.printf("＃%sさんの対戦成績：%s\n", name, record.toString());
	}

	/**
	 * プレイヤの名前を取得する
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * プレイヤの手札を取得する
	 * @return 手札
	 */
	public CardDeck getHand() {
		return hand;
	}

	/**
	 * プレイヤの対戦成績を取得する
	 * @return 対戦成績
	 */
	public Record getRecord() {
		return record;
	}
	
	/**
	 * プレイヤの手札をセットする
	 * @param cd
	 * 			手札
	 */
	public void setHand(CardDeck cd) {
		this.hand=cd;
	}
	
	/**
	 * １位をとった数を１増やす
	 */
	public void first() {
		int count=record.getFirst();
		count++;
		record.setFirst(count);
	}
	
	/**
	 * ２位を取った数を１増やす
	 */
	public void second() {
		int count=record.getSecond();
		count++;
		record.setSecond(count);
	}
	
	/**
	 * 3位を取った数を１増やす
	 */
	public void third() {
		int count=record.getThird();
		count++;
		record.setThird(count);
	}
}
