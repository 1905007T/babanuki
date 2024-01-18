package se.t1905007.card.game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import se.t1905007.card.entity.CPU;
import se.t1905007.card.entity.Record;
import se.t1905007.card.entity.User;
import se.t1905007.card.util.KeyBoard;

/**
 * ババ抜きゲームアプリ
 * @author Ryusei
 *
 */
public class BabanukiApplication {
	private User user; //ユーザ
	private static final String logFile= "babanuki.log"; //ログファイル
	private BabanukiGame game; //ババ抜きゲーム

	public BabanukiApplication() {

	}

	/**
	 * アプリを開始する
	 */
	public void startApplication() {
		initialize();
		doGame();
		storeRecord();
	}

	/**
	 * ババ抜きの初期設定をする
	 */
	public void initialize() {
		// 名前入力
		System.out.println("■じゃんけんゲームアプリを起動します．");
		System.out.print("名前を入力してください：　");
		String name = KeyBoard.inputString();

		// プレイヤ数，ゲーム回数をそれぞれ入力
		int m, n;
		do {
			System.out.print("何人で遊びますか(2以上の整数)：");
			n = KeyBoard.inputNumber();
		} while (n < 2);

		do {
			System.out.print("何回戦しますか(1以上の整数)：");
			m = KeyBoard.inputNumber();
		} while (m < 1);

		// ゲームを作成
		game = new BabanukiGame();

		// ユーザを追加
		user = new User(name);
		game.addPlayer(user);

		// CPUを追加 (n-1)人分
		for (int i = 1; i < n; i++) {
			game.addPlayer(new CPU("CPU" + i));
		}
		// 対戦回数を設定
		game.setNumberOfGames(m);
	}

	/**
	 * ババ抜きを行う
	 */
	public void doGame() {
		game.startGame();
	}

	/**
	 * 成績を記録する
	 */
	public void storeRecord() {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
			Calendar cl = Calendar.getInstance();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(cl.getTime());
			Record r = user.getRecord();
			//ログのフォーマット
			String out = String.format("%s,%s,%d,%d,%d,%d,%d",
					date, //日付　yyyy-MM-dd HH:mm:ss
					user.getName(), //ユーザ名
					game.getPlayers().size(), //プレイヤ数
					game.getNumberOfGames(), //対戦回数
					r.getFirst(), //１位の数
					r.getSecond(), //２位の数
					r.getThird() //３位の数
			);

			System.out.printf("■%sさんの対戦成績をファイルに追記します．\n",
					user.getName());
			System.out.println(out);
			//ログを書き出す
			pw.println(out);
			pw.close();
			System.out.println("完了しました．");
		} catch (IOException e) {
			System.out.println(logFile + "：ファイル書き込み中，IO例外です．");
			e.printStackTrace();
		}
	}
}
