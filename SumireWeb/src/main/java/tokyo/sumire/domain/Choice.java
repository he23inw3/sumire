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

    /**
     * 正解フラグ
     */
    private boolean correctFlg;
}
