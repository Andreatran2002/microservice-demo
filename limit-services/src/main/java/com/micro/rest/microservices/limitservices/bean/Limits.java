package com.micro.rest.microservices.limitservices.bean;

public class Limits {
    int max ;
    int min ;

    public Limits() {
    }

    public Limits(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
