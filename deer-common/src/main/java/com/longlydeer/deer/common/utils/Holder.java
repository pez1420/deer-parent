package com.longlydeer.deer.common.utils;


/**
 * Helper calsss for hold a value
 *
 * @author pez1420
 */
public class Holder<T> {

    private  volatile T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
