package com.aconex.eighthundredchallenge.mapper;

/**
 * Maps each charcter of the alphabet to a bit mask.
 * <p>
 * Created by aaron.spiteri on 24/09/2016.
 */

public enum CharacterBitmap implements EightHundredBitMap {
    C_A('A', 0),
    C_B('B', 1),
    C_C('C', 2),
    C_D('D', 3),
    C_E('E', 4),
    C_F('F', 5),
    C_G('G', 6),
    C_H('H', 7),
    C_I('I', 8),
    C_J('J', 9),
    C_K('K', 10),
    C_L('L', 11),
    C_M('M', 12),
    C_N('N', 13),
    C_O('O', 14),
    C_P('P', 15),
    C_Q('Q', 16),
    C_R('R', 17),
    C_S('S', 18),
    C_T('T', 19),
    C_U('U', 20),
    C_V('V', 21),
    C_W('W', 22),
    C_X('X', 23),
    C_Y('Y', 24),
    C_Z('Z', 25);

    private int bitMask;
    private char key;

    CharacterBitmap(char key, int setBit) {
        bitMask = 1 << setBit;
        this.key = key;
    }

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
