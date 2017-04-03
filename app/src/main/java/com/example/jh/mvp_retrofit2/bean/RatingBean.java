package com.example.jh.mvp_retrofit2.bean;

/**
 * 作者：jinhui on 2017/4/1
 * 邮箱：1004260403@qq.com
 */

public class RatingBean {
    private int max;
    private int numRaters;
    private String average;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "RatingBean{" +
                "max=" + max +
                ", numRaters=" + numRaters +
                ", average='" + average + '\'' +
                ", min=" + min +
                '}';
    }
}
