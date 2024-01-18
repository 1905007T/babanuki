package se.t1905007.card.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoard {

	/**
	 * ユーザに整数を1つ入力してもらい，返り値として返す． 
	 * 正しい入力が得られるまで繰り返す．
	 *
	 */
	public static int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = inputNumber(); // 再起呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再起呼び出し
		}

		return number;
	}

	/**
	 * キーボードから1行読み取る．エラーがあれば再入力させる．
	 *
	 * @return 読み込んだ文字列
	 */
	public static String inputString() {
		String line;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("エラー：入出力例外です．もう一度入力．");
			line = inputString(); // 再起呼び出し
		}

		return line;

	}
}
