package orc.modelOcr;

import java.util.List;

/**
 * @Title: ModelOcrData
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description 自定义模板识别文字内容返回结果
 * @author: willinggod
 * @date: 2018/3/16 13:20
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class ModelOcrData {
    List<Ret> ret;
    /**
     * 调用的日志id
     */
    private String logId;
    /**
     * 表示是否结构话成功，true为成功，false为失败；
     * 成功时候，返回结构化的识别结果；
     * 失败时，如果能识别，返回类似通用文字识别的结果，如果不能识别，返回空
     */
    private boolean isStructured;

    public List<Ret> getRet() {
        return ret;
    }

    public void setRet(List<Ret> ret) {
        this.ret = ret;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public boolean isStructured() {
        return isStructured;
    }

    public void setStructured(boolean structured) {
        isStructured = structured;
    }
}
