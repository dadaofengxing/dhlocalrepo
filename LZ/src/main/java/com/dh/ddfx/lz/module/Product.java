package com.dh.ddfx.lz.module;


/**
 * @author DELL
 */
public class Product {
    private String id;
    private String src;
    private String length;//总长
    private String renLength;//刃长
    private String bingLength;//柄长
    private String weight;//种高粱
    private int index;
    private int status;
    private String otherProp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRenLength() {
        return renLength;
    }

    public void setRenLength(String renLength) {
        this.renLength = renLength;
    }

    public String getBingLength() {
        return bingLength;
    }

    public void setBingLength(String bingLength) {
        this.bingLength = bingLength;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOtherProp() {
        return otherProp;
    }

    public void setOtherProp(String otherProp) {
        this.otherProp = otherProp;
    }
}
