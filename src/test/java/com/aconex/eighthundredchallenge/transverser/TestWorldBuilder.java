package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import org.junit.Test;

import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.cloneWordBuilder;
import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.createWordBuilder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 28/09/2016.
 */
public class TestWorldBuilder {
    private DigitMapper dmapper = new DigitMapper();

    @Test
    public void shouldCreateWordBuilder() {
        String digitString = "225563";
        WordBuilder wb = createWordBuilder(digitString, dmapper);

        assertThat(wb.getDigitString(), is(digitString));
        assertThat(wb.getMapper(), is(dmapper));
    }

    @Test
    public void shouldCloneWordBuilder() {
        String digitString = "225563";
        WordBuilder wb = createWordBuilder(digitString, dmapper);

        assertThat(wb.getDigitString(), is(digitString));
        assertThat(wb.getMapper(), is(dmapper));

        WordBuilder wb2 = cloneWordBuilder(wb);
        assertThat(wb2.getDigitString(), is(digitString));
        assertThat(wb2.getMapper(), is(dmapper));
    }
}
