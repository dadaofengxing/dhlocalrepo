package orc.modelOcr;

/**
 * @Title: ModelOcrText
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description:
 * @author: willinggod
 * @date: 2018/3/16 13:29
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class ModelOcrText {
    /**
     * 识别区名称
     */
    private String word_name;
    /**
     * 识别区文字
     */
    private String word;

    public String getWord_name() {
        return word_name;
    }

    public void setWord_name(String word_name) {
        this.word_name = word_name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
