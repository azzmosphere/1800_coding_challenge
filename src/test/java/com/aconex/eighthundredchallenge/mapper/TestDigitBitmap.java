package com.aconex.eighthundredchallenge.mapper;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by aaron.spiteri on 26/09/2016.
 */
public class TestDigitBitmap {

    @Test
    public void shouldMapBitMasks() {
        assertFalse((CharacterBitmap.C_A.getBitMask() & DigitBitmap.D_1.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_A.getBitMask() & DigitBitmap.D_2.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_B.getBitMask() & DigitBitmap.D_2.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_C.getBitMask() & DigitBitmap.D_2.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_D.getBitMask() & DigitBitmap.D_3.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_E.getBitMask() & DigitBitmap.D_3.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_F.getBitMask() & DigitBitmap.D_3.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_G.getBitMask() & DigitBitmap.D_4.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_H.getBitMask() & DigitBitmap.D_4.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_I.getBitMask() & DigitBitmap.D_4.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_J.getBitMask() & DigitBitmap.D_5.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_K.getBitMask() & DigitBitmap.D_5.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_L.getBitMask() & DigitBitmap.D_5.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_M.getBitMask() & DigitBitmap.D_6.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_N.getBitMask() & DigitBitmap.D_6.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_O.getBitMask() & DigitBitmap.D_6.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_P.getBitMask() & DigitBitmap.D_7.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_Q.getBitMask() & DigitBitmap.D_7.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_R.getBitMask() & DigitBitmap.D_7.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_S.getBitMask() & DigitBitmap.D_7.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_T.getBitMask() & DigitBitmap.D_8.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_U.getBitMask() & DigitBitmap.D_8.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_V.getBitMask() & DigitBitmap.D_8.getBitMask()) > 0);

        assertTrue((CharacterBitmap.C_W.getBitMask() & DigitBitmap.D_9.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_X.getBitMask() & DigitBitmap.D_9.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_Y.getBitMask() & DigitBitmap.D_9.getBitMask()) > 0);
        assertTrue((CharacterBitmap.C_Z.getBitMask() & DigitBitmap.D_9.getBitMask()) > 0);

    }
}
