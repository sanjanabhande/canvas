package com.sanjana.canvas.model;

public class DrawVO {

    int startWidth;
    int endWidth;
    int startHeight;
    int endHeight;
    String drawSymbol;

    public int getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getEndWidth() {
        return endWidth;
    }

    public void setEndWidth(int endWidth) {
        this.endWidth = endWidth;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public void setStartHeight(int startHeight) {
        this.startHeight = startHeight;
    }

    public int getEndHeight() {
        return endHeight;
    }

    public void setEndHeight(int endHeight) {
        this.endHeight = endHeight;
    }

    public String getDrawSymbol() {
        return drawSymbol;
    }

    public void setDrawSymbol(String drawSymbol) {
        this.drawSymbol = drawSymbol;
    }
}
