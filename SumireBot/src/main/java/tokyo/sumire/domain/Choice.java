package tokyo.sumire.domain;

import lombok.Data;

/**
 * <dl>
 * <dt><b>クラス機能概要: </b></dt>
 * <dd>選択肢</dd>
 * </dl>
 *
 * @author hiro72
 *
 */
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
	 * 女優URI
	 */
	private String imageUri;

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
