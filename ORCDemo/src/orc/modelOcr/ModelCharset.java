package orc.modelOcr;

/**
 * @Title: ModelCharset
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description 范围识别文字对象
 * @author: willinggod
 * @date: 2018/3/16 13:15
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class ModelCharset {
    /**
     * 识别文字
     */
    private String word;
    /**
     * 识别范围
     */
    private Rect rect;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
