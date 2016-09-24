package com.aconex.eighthundredchallenge.mapper;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aaron.spiteri on 24/09/2016.
 */
public class TestCharacterBitmap {

    @Test
    public void shouldMapBitMasks() {

        assertTrue(CharacterBitmap.C_A.getBitMask() == 1);
        assertTrue(CharacterBitmap.C_B.getBitMask() == 2);
        assertTrue(CharacterBitmap.C_C.getBitMask() == 4);
        assertTrue(CharacterBitmap.C_D.getBitMask() == 8);
        assertTrue(CharacterBitmap.C_E.getBitMask() == 16);
        assertTrue(CharacterBitmap.C_F.getBitMask() == 32);
        assertTrue(CharacterBitmap.C_G.getBitMask() == 64);
        assertTrue(CharacterBitmap.C_H.getBitMask() == 128);
        assertTrue(CharacterBitmap.C_I.getBitMask() == 256);
        assertTrue(CharacterBitmap.C_J.getBitMask() == 512);
        assertTrue(CharacterBitmap.C_K.getBitMask() == 1024);
        assertTrue(CharacterBitmap.C_L.getBitMask() == 2048);
        assertTrue(CharacterBitmap.C_M.getBitMask() == 4096);
        assertTrue(CharacterBitmap.C_N.getBitMask() == 8192);
        assertTrue(CharacterBitmap.C_O.getBitMask() == 16384);
        assertTrue(CharacterBitmap.C_P.getBitMask() == 32768);
        assertTrue(CharacterBitmap.C_Q.getBitMask() == 65536);
        assertTrue(CharacterBitmap.C_R.getBitMask() == 131072);
        assertTrue(CharacterBitmap.C_S.getBitMask() == 262144);
        assertTrue(CharacterBitmap.C_T.getBitMask() == 524288);
        assertTrue(CharacterBitmap.C_U.getBitMask() == 1048576);
        assertTrue(CharacterBitmap.C_V.getBitMask() == 2097152);
        assertTrue(CharacterBitmap.C_W.getBitMask() == 4194304);
        assertTrue(CharacterBitmap.C_X.getBitMask() == 8388608);
        assertTrue(CharacterBitmap.C_Y.getBitMask() == 16777216);
        assertTrue(CharacterBitmap.C_Z.getBitMask() == 33554432);
    }

    @Test
    public void shouldMapCharacters() {
        assertTrue(CharacterBitmap.C_A.getKey() == 'A');
        assertTrue(CharacterBitmap.C_B.getKey() == 'B');
        assertTrue(CharacterBitmap.C_C.getKey() == 'C');
        assertTrue(CharacterBitmap.C_D.getKey() == 'D');
        assertTrue(CharacterBitmap.C_E.getKey() == 'E');
        assertTrue(CharacterBitmap.C_F.getKey() == 'F');
        assertTrue(CharacterBitmap.C_G.getKey() == 'G');
        assertTrue(CharacterBitmap.C_H.getKey() == 'H');
        assertTrue(CharacterBitmap.C_I.getKey() == 'I');
        assertTrue(CharacterBitmap.C_J.getKey() == 'J');
        assertTrue(CharacterBitmap.C_K.getKey() == 'K');
        assertTrue(CharacterBitmap.C_L.getKey() == 'L');
        assertTrue(CharacterBitmap.C_M.getKey() == 'M');
        assertTrue(CharacterBitmap.C_N.getKey() == 'N');
        assertTrue(CharacterBitmap.C_O.getKey() == 'O');
        assertTrue(CharacterBitmap.C_P.getKey() == 'P');
        assertTrue(CharacterBitmap.C_Q.getKey() == 'Q');
        assertTrue(CharacterBitmap.C_R.getKey() == 'R');
        assertTrue(CharacterBitmap.C_S.getKey() == 'S');
        assertTrue(CharacterBitmap.C_T.getKey() == 'T');
        assertTrue(CharacterBitmap.C_U.getKey() == 'U');
        assertTrue(CharacterBitmap.C_V.getKey() == 'V');
        assertTrue(CharacterBitmap.C_W.getKey() == 'W');
        assertTrue(CharacterBitmap.C_X.getKey() == 'X');
        assertTrue(CharacterBitmap.C_Y.getKey() == 'Y');
        assertTrue(CharacterBitmap.C_Z.getKey() == 'Z');
    }

}
