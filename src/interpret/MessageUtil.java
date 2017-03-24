package interpret;

import javax.swing.JOptionPane;

public class MessageUtil {

	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void showClassError() {
		JOptionPane.showMessageDialog(null, "クラス名が不正です。","Class Not Found" ,JOptionPane.ERROR_MESSAGE);
	}
	public static void invalidSelectError() {
		JOptionPane.showMessageDialog(null, "アイテムリストを選択してください。","Invalid Selection" ,JOptionPane.ERROR_MESSAGE);
	}
	public static void notFoundFieldError() {
		JOptionPane.showMessageDialog(null, "フィールドを選択できませんでした。","Invalid Selection" ,JOptionPane.ERROR_MESSAGE);
	}
	public static void cannotCreateObjError() {
		JOptionPane.showMessageDialog(null, "オブジェクトを生成できませんでした。以下の理由が考えられます。" + NEW_LINE +
				"・引数無しのコンストラクタが定義されていない。" + NEW_LINE +
				"・抽象クラス、インタフェースを指している。"
				,"cannot create object" ,JOptionPane.ERROR_MESSAGE);
	}

}
