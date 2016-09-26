package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;
import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public class TestWordBuilder {

    private DigitMapper dmapper = new DigitMapper();

    @Test
    public void shouldBuildWord() {
        String digitString = "2255";

        WordBuilder wb = new WordBuilder(digitString, dmapper);

        assertTrue(wb.append(CharacterBitmap.C_C));
        assertTrue(wb.append(CharacterBitmap.C_A));
        assertTrue(wb.append(CharacterBitmap.C_L));
        assertTrue(wb.append(CharacterBitmap.C_L));

        assertThat(wb.getWord(), is("CALL"));
    }

    @Test
    public void shouldFindWordEnd() {
        String digitString = "2255";

        WordBuilder wb = new WordBuilder(digitString, dmapper);

        assertTrue(wb.append(CharacterBitmap.C_C));
        assertTrue(wb.append(CharacterBitmap.C_A));
        assertTrue(wb.append(CharacterBitmap.C_L));
        assertTrue(wb.append(CharacterBitmap.C_L));
        assertFalse(wb.append(CharacterBitmap.C_M));

        assertThat(wb.getWord(), is("CALL"));
    }

    @Test
    public void shouldSetBoundry() {
        String digitString = "225563";

        WordBuilder wb = new WordBuilder(digitString, dmapper);

        assertTrue(wb.append(CharacterBitmap.C_C));
        assertTrue(wb.append(CharacterBitmap.C_A));
        assertTrue(wb.append(CharacterBitmap.C_L));
        assertTrue(wb.append(CharacterBitmap.C_L));

        wb.setBoundry();

        assertTrue(wb.append(CharacterBitmap.C_M));
        assertTrue(wb.append(CharacterBitmap.C_E));

        assertThat(wb.getWord(), is("CALL-ME"));
    }
}
