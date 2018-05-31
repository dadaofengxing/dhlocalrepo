package orc.modelOcr;

/**
 * @Title: ModelOcrResponse
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description: 自定义模板接口返回结果对象
 * @author: willinggod
 * @date: 2018/3/16 13:22
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class ModelOcrResponse {
    /**
     * 识别返回的结果
     */
    private ModelOcrData data;
    /**
     * 0代表成功，如果有错误码返回可以参考下方错误码列表排查问题
     */
    private int error_code;
    /**
     * 如果error_code具体的失败信息，可以参考下方错误码列表排查问题
     */
    private String error_msg;

    public ModelOcrData getData() {
        return data;
    }

    public void setData(ModelOcrData data) {
        this.data = data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
