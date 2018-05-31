package orc.modelOcr;

import java.util.List;

/**
 * @Title: Ret
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description:
 * @author: willinggod
 * @date: 2018/3/16 13:18
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class Ret {
    /**
     * 自定义识别区的名字
     */
    private String word_name;
    /**
     * 详细识别区识别范围和对象的识别文字集合
     */
    List<ModelCharset> charset;
    /**
     * 识别区整体识别文字内容
     */
    private String word;

    public String getWord_name() {
        return word_name;
    }

    public void setWord_name(String word_name) {
        this.word_name = word_name;
    }

    public List<ModelCharset> getCharset() {
        return charset;
    }

    public void setCharset(List<ModelCharset> charset) {
        this.charset = charset;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
