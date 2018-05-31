package orc.plainOcr;

import orc.plainOcr.Word;

import java.util.List;

/**
 * @Title: OcrEntity
 * @Prject: ORCDemo
 * @Package: smail
 * @Description:
 * @author: willinggod
 * @date: 2018/3/8 21:45
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class OcrEntity {
    private String log_id;
    private List<Word> words_result;
    private int words_result_num;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public List<Word> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<Word> words_result) {
        this.words_result = words_result;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }
}
