package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.Mapper;

/**
 * Created by aaron.spiteri on 28/09/2016.
 */
public class WordBuilderFactory {
    public static WordBuilder createWordBuilder(String digits, Mapper mapper) {
        return new WordBuilder(digits, mapper);
    }

    public static WordBuilder cloneWordBuilder(WordBuilder wb) {

        return new WordBuilder(wb.getDigitString(), wb.getMapper(), wb.getWord());
    }

}
