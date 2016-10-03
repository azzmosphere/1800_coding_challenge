package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.Mapper;

/**
 *
 * Factory class to create and clone word builders
 *
 * Created by aaron.spiteri on 28/09/2016.
 */
public class WordBuilderFactory {

    /**
     * Creates a new instance of a word builder.
     * @param digits
     * @param mapper
     * @return word builder
     */
    public static WordBuilder createWordBuilder(String digits, Mapper mapper) {
        return new WordBuilder(digits, mapper);
    }

    /**
     * creates a clone of the word builder
     * @param wb
     * @return clone
     */
    public static WordBuilder cloneWordBuilder(WordBuilder wb) {

        return new WordBuilder(wb.getDigitString(), wb.getMapper(), wb.getWord());
    }

}
