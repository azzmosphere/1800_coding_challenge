package com.aconex.eighthundredchallenge.mapper;

import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_A;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_B;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_C;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_D;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_E;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_F;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_G;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_H;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_I;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_J;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_K;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_L;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_M;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_N;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_O;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_P;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_Q;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_R;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_S;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_T;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_U;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_V;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_W;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_X;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_Y;
import static com.aconex.eighthundredchallenge.mapper.CharacterBitmap.C_Z;

/**
 * Digit character mapping.
 *
 * Created by aaron.spiteri on 26/09/2016.
 */
public enum DigitBitmap implements EightHundredBitMap {

    D_0('0', 0),
    D_1('1', 0),
    D_2('2', C_A.getBitMask() | C_B.getBitMask() | C_C.getBitMask()),
    D_3('3', C_D.getBitMask() | C_E.getBitMask() | C_F.getBitMask()),
    D_4('4', C_G.getBitMask() | C_H.getBitMask() | C_I.getBitMask()),
    D_5('5', C_J.getBitMask() | C_K.getBitMask() | C_L.getBitMask()),
    D_6('6', C_M.getBitMask() | C_N.getBitMask() | C_O.getBitMask()),
    D_7('7', C_P.getBitMask() | C_Q.getBitMask() | C_R.getBitMask() | C_S.getBitMask()),
    D_8('8', C_T.getBitMask() | C_U.getBitMask() | C_V.getBitMask()),
    D_9('9', C_W.getBitMask() | C_X.getBitMask() | C_Y.getBitMask() | C_Z.getBitMask());

    DigitBitmap(char key, int bitMask) {
        this.key = key;
        this.bitMask = bitMask;
    }

    private int bitMask;
    private char key;

    /**
     * return the bitmap as a big integer.
     *
     * @return bitMap
     */
    @Override
    public int getBitMask() {
        return bitMask;
    }

    @Override
    public char getKey() {
        return key;
    }
}
