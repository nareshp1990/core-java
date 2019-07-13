package com.naresh.volatileexample;

public class VolatileTest {

    private volatile int cnt = 0;
//    private int cnt = 0;

    public int getCntValue() {
        return cnt;
    }

    public void incrementCnt() {
        ++cnt;
    }

}
