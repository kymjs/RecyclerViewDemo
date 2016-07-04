package com.kymjs.view.recycler.data;

import android.support.annotation.DrawableRes;

/**
 * Created by ZhangTao on 7/4/16.
 */
public class Data {
    private String num;
    private String time;
    @DrawableRes
    private int resImage;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @DrawableRes
    public int getResImage() {
        return resImage;
    }

    public void setResImage(@DrawableRes int resImage) {
        this.resImage = resImage;
    }
}
