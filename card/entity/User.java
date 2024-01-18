package se.t1905007.card.entity;

import se.t1905007.card.util.KeyBoard;

/**
 * ババ抜きのユーザプレイヤ．ユーザがキーボードから手動でとるカードを選ぶ．
 * 
 * @author Ryusei
 *
 */
public class User extends Player {

	public User(String name) {
		super(name);
	}

	/**
	 * ユーザがとるカードを選ぶ．
	 */
	@Override
	public int chooseCard(Player player) {

		int i;
		do {
			System.out.print(player.getName() + "さんは" + player.getHand().size() + "枚のカードを持っています．何枚目のカードを取りますか？：");
			i = KeyBoard.inputNumber();
			if (i <= 0 || i > player.getHand().size())
				System.out.println("そのようなカードはありません．やり直します．");
		} while (i <= 0 || i > player.getHand().size());
		return i;
	}

}
