package com.icaballero.javatest.util;

import org.junit.Test;

import static com.icaballero.javatest.util.PasswordUtill.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtillTest {


    @Test
    public void weak_when_has_less_than_8_letter() {

       assertEquals(WEAK,PasswordUtill.asssessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters() {

        assertEquals(WEAK,PasswordUtill.asssessPassword("abcdefgH"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {

        assertEquals(MEDIUM,PasswordUtill.asssessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {

        assertEquals(STRONG,PasswordUtill.asssessPassword("abcd1234!"));
    }



}