package com.aconex.eighthundredchallenge.mapper;

import java.util.HashMap;

/**
 * Created by aaron.spiteri on 24/09/2016.
 */
public class CharacterMapper {
    private HashMap<Character, CharacterBitmap> characters = new HashMap<>(CharacterBitmap.values().length);

    public CharacterMapper() {
        for (CharacterBitmap c : CharacterBitmap.values()) {
            characters.put(c.getKey(), c);
        }
    }

    /**
     * retrieve the bitmap for a given character c
     *
     * @param c
     * @return bitmask
     */
    public int getBitMask(char c) {
        c = Character.toUpperCase(c);
        return characters.get(c).getBitMask();
    }

    /**
     * assert if character 'c' is with in the characterbitmap
     *
     * @param c
     * @return true on success otherwise false.
     */
    public boolean hasChar(char c) {
        return characters.containsKey(Character.toUpperCase(c));
    }

}
