package se.t1905007.card.entity;

/**
 * ババ抜きの対戦成績クラス．１位の数，２位の数，３位の数を持つ
 * 
 * @author Ryusei
 *
 */
public class Record {
	
	private int first;
	private int second;
	private int third;
	

	/**
	 * デフォルトコンストラクタ．対戦成績のないものを作成．
	 */
	public Record() {
		this(0,0,0);
		
	}

	/**
	 * 引数を与えて対戦成績を作成．
	 * @param first
	 * 				１位の数
	 * @param second
	 * 				２位の数
	 * @param third
	 * 				３位の数
	 */
	public Record(int first, int second, int third) {
		super();
		this.first=first;
		this.second=second;
		this.third=third;
	}

	/**
	 * １位の数を取得する
	 * @return １位の数
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * １位の数をセットする
	 * @param first
	 * 				１位の数
	 */
	public void setFirst(int first) {
		this.first = first;
	}

	/**
	 * 2位の数を取得する
	 * @return 2位の数
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * ２位の数をセットする
	 * @param second
	 * 				２位の数
	 */
	public void setSecond(int second) {
		this.second = second;
	}

	/**
	 * 3位の数を取得する
	 * @return 3位の数
	 */
	public int getThird() {
		return third;
	}

	/**
	 * ３位の数をセットする
	 * @param third
	 * 				３位の数
	 */
	public void setThird(int third) {
		this.third = third;
	}

	
	@Override
	public String toString() {
		return String.format("1位%d回，2位%d回，3位%d回", first, second, third);
	}
}
