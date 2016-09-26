package com.aconex.eighthundredchallenge.mapper;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public interface Mapper<T> {
    int getBitMask(char c);
    T getCharacterBitmap(char c);
}
