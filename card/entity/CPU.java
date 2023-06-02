package se.t1905007.card.entity;

import java.util.Random;

/**
 * ババ抜きのCPUプレイヤ．自動的にコンピュータが手を決める．
 * @author Ryusei
 *
 */
public class CPU extends Player {
	private Random r = new Random();

	/**
	 * 名前を指定してCPUプレイヤを作成する
	 * @param name 名前
	 */
	public CPU(String name) {
		super(name);
	}

	/**
	 * CPUが手を選ぶ
	 */
	@Override
	public int chooseCard(Player player) {
		System.out.printf("○%sがとるカードを決めています．\n", name);
		return r.nextInt(player.getHand().size())+1;
	}
}
