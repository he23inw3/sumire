package tokyo.sumire.domain;

import lombok.Data;

@Data
public class Choice {
	/**
	 * 女優名
	 */
	private String name;

	/**
	 * 選択肢ID
	 */
	private String choiceId;

	/**
	 * 女優画像URI
	 */
	private String imageUri;

	/**
	 * 女優情報URI
	 */
	private String infoUri;

	/**
	 * 正解フラグ
	 */
	private boolean correctFlg;

	/**
	 * バストサイズ
	 */
	private int bust;

	/**
	 * ウェストサイズ
	 */
	private int west;

	/**
	 * ヒップサイズ
	 */
	private int hip;
}
