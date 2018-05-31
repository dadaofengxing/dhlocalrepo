package orc.modelOcr;

import java.util.List;

/**
 * @Title: ModelOcr
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description:
 * @author: willinggod
 * @date: 2018/3/16 13:30
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class ModelOcr {
    List<ModelOcrText> words;

    public List<ModelOcrText> getWords() {
        return words;
    }

    public void setWords(List<ModelOcrText> words) {
        this.words = words;
    }
}
