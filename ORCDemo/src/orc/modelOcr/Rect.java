package orc.modelOcr;

/**
 * @Title: Rect
 * @Prject: ORCDemo
 * @Package: orc.modelOcr
 * @Description 图片位置坐标对象
 * @author: willinggod
 * @date: 2018/3/16 13:16
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class Rect {
    private int height;
    private int width;
    private int left;
    private int top;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
