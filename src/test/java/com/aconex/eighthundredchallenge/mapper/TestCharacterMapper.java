package com.aconex.eighthundredchallenge.mapper;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by aaron.spiteri on 24/09/2016.
 */
public class TestCharacterMapper {
    private CharacterMapper mapper = new CharacterMapper();

    @Test
    public void shouldAssertCharacters() {
        assertTrue(mapper.hasChar('a'));
        assertTrue(mapper.hasChar('A'));

        assertTrue(mapper.hasChar('b'));
        assertTrue(mapper.hasChar('B'));

        assertTrue(mapper.hasChar('c'));
        assertTrue(mapper.hasChar('C'));

        assertTrue(mapper.hasChar('d'));
        assertTrue(mapper.hasChar('D'));

        assertTrue(mapper.hasChar('e'));
        assertTrue(mapper.hasChar('E'));

        assertTrue(mapper.hasChar('f'));
        assertTrue(mapper.hasChar('F'));

        assertTrue(mapper.hasChar('g'));
        assertTrue(mapper.hasChar('G'));

        assertTrue(mapper.hasChar('h'));
        assertTrue(mapper.hasChar('H'));

        assertTrue(mapper.hasChar('i'));
        assertTrue(mapper.hasChar('I'));

        assertTrue(mapper.hasChar('j'));
        assertTrue(mapper.hasChar('J'));

        assertTrue(mapper.hasChar('k'));
        assertTrue(mapper.hasChar('K'));

        assertTrue(mapper.hasChar('l'));
        assertTrue(mapper.hasChar('L'));

        assertTrue(mapper.hasChar('m'));
        assertTrue(mapper.hasChar('M'));

        assertTrue(mapper.hasChar('n'));
        assertTrue(mapper.hasChar('N'));

        assertTrue(mapper.hasChar('o'));
        assertTrue(mapper.hasChar('O'));

        assertTrue(mapper.hasChar('p'));
        assertTrue(mapper.hasChar('P'));

        assertTrue(mapper.hasChar('q'));
        assertTrue(mapper.hasChar('Q'));

        assertTrue(mapper.hasChar('r'));
        assertTrue(mapper.hasChar('R'));

        assertTrue(mapper.hasChar('s'));
        assertTrue(mapper.hasChar('S'));

        assertTrue(mapper.hasChar('t'));
        assertTrue(mapper.hasChar('T'));

        assertTrue(mapper.hasChar('u'));
        assertTrue(mapper.hasChar('U'));

        assertTrue(mapper.hasChar('v'));
        assertTrue(mapper.hasChar('V'));

        assertTrue(mapper.hasChar('w'));
        assertTrue(mapper.hasChar('W'));

        assertTrue(mapper.hasChar('x'));
        assertTrue(mapper.hasChar('X'));

        assertTrue(mapper.hasChar('y'));
        assertTrue(mapper.hasChar('Y'));

        assertTrue(mapper.hasChar('z'));
        assertTrue(mapper.hasChar('Z'));
    }

    @Test
    public void shouldNotHaveCharacters() {
        assertFalse(mapper.hasChar('.'));
        assertFalse(mapper.hasChar('?'));
        assertFalse(mapper.hasChar('*'));
        assertFalse(mapper.hasChar(' '));
        assertFalse(mapper.hasChar('\t'));
        assertFalse(mapper.hasChar('1'));
    }

    @Test
    public void shouldGetBitMap() {
        assertTrue(mapper.getBitMask('a') == CharacterBitmap.C_A.getBitMask());
        assertTrue(mapper.getBitMask('b') == CharacterBitmap.C_B.getBitMask());
        assertTrue(mapper.getBitMask('c') == CharacterBitmap.C_C.getBitMask());
        assertTrue(mapper.getBitMask('d') == CharacterBitmap.C_D.getBitMask());
        assertTrue(mapper.getBitMask('e') == CharacterBitmap.C_E.getBitMask());
        assertTrue(mapper.getBitMask('f') == CharacterBitmap.C_F.getBitMask());
        assertTrue(mapper.getBitMask('g') == CharacterBitmap.C_G.getBitMask());
        assertTrue(mapper.getBitMask('h') == CharacterBitmap.C_H.getBitMask());
        assertTrue(mapper.getBitMask('i') == CharacterBitmap.C_I.getBitMask());
        assertTrue(mapper.getBitMask('j') == CharacterBitmap.C_J.getBitMask());
        assertTrue(mapper.getBitMask('k') == CharacterBitmap.C_K.getBitMask());
        assertTrue(mapper.getBitMask('l') == CharacterBitmap.C_L.getBitMask());
        assertTrue(mapper.getBitMask('m') == CharacterBitmap.C_M.getBitMask());
        assertTrue(mapper.getBitMask('n') == CharacterBitmap.C_N.getBitMask());
        assertTrue(mapper.getBitMask('o') == CharacterBitmap.C_O.getBitMask());
        assertTrue(mapper.getBitMask('p') == CharacterBitmap.C_P.getBitMask());
        assertTrue(mapper.getBitMask('q') == CharacterBitmap.C_Q.getBitMask());
        assertTrue(mapper.getBitMask('r') == CharacterBitmap.C_R.getBitMask());
        assertTrue(mapper.getBitMask('s') == CharacterBitmap.C_S.getBitMask());
        assertTrue(mapper.getBitMask('t') == CharacterBitmap.C_T.getBitMask());
        assertTrue(mapper.getBitMask('u') == CharacterBitmap.C_U.getBitMask());
        assertTrue(mapper.getBitMask('v') == CharacterBitmap.C_V.getBitMask());
        assertTrue(mapper.getBitMask('w') == CharacterBitmap.C_W.getBitMask());
        assertTrue(mapper.getBitMask('x') == CharacterBitmap.C_X.getBitMask());
        assertTrue(mapper.getBitMask('y') == CharacterBitmap.C_Y.getBitMask());
        assertTrue(mapper.getBitMask('z') == CharacterBitmap.C_Z.getBitMask());
    }

    @Test
    public void shouldGetCharacterMapper() {
        assertThat(mapper.getCharacterBitmap('a'), is(CharacterBitmap.C_A));
        assertThat(mapper.getCharacterBitmap('b'), is(CharacterBitmap.C_B));
        assertThat(mapper.getCharacterBitmap('c'), is(CharacterBitmap.C_C));
        assertThat(mapper.getCharacterBitmap('d'), is(CharacterBitmap.C_D));
        assertThat(mapper.getCharacterBitmap('e'), is(CharacterBitmap.C_E));
        assertThat(mapper.getCharacterBitmap('f'), is(CharacterBitmap.C_F));
        assertThat(mapper.getCharacterBitmap('g'), is(CharacterBitmap.C_G));
        assertThat(mapper.getCharacterBitmap('h'), is(CharacterBitmap.C_H));
        assertThat(mapper.getCharacterBitmap('i'), is(CharacterBitmap.C_I));
        assertThat(mapper.getCharacterBitmap('j'), is(CharacterBitmap.C_J));
        assertThat(mapper.getCharacterBitmap('k'), is(CharacterBitmap.C_K));
        assertThat(mapper.getCharacterBitmap('l'), is(CharacterBitmap.C_L));
        assertThat(mapper.getCharacterBitmap('m'), is(CharacterBitmap.C_M));
        assertThat(mapper.getCharacterBitmap('n'), is(CharacterBitmap.C_N));
        assertThat(mapper.getCharacterBitmap('o'), is(CharacterBitmap.C_O));
        assertThat(mapper.getCharacterBitmap('p'), is(CharacterBitmap.C_P));
        assertThat(mapper.getCharacterBitmap('q'), is(CharacterBitmap.C_Q));
        assertThat(mapper.getCharacterBitmap('r'), is(CharacterBitmap.C_R));
        assertThat(mapper.getCharacterBitmap('s'), is(CharacterBitmap.C_S));
        assertThat(mapper.getCharacterBitmap('t'), is(CharacterBitmap.C_T));
        assertThat(mapper.getCharacterBitmap('u'), is(CharacterBitmap.C_U));
        assertThat(mapper.getCharacterBitmap('v'), is(CharacterBitmap.C_V));
        assertThat(mapper.getCharacterBitmap('w'), is(CharacterBitmap.C_W));
        assertThat(mapper.getCharacterBitmap('x'), is(CharacterBitmap.C_X));
        assertThat(mapper.getCharacterBitmap('y'), is(CharacterBitmap.C_Y));
        assertThat(mapper.getCharacterBitmap('z'), is(CharacterBitmap.C_Z));
    }
}
