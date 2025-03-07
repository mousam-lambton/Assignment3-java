package com.service;

public class PageCounter {
    private Integer pageCounter = 0;

    public void increment() {
        pageCounter++;
    }

    public Integer getPageCount() {
        return pageCounter;
    }
}