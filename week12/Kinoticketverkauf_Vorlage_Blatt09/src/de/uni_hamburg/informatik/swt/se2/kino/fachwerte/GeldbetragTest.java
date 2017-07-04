package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

public class GeldbetragTest
{
    Geldbetrag _value1 = Geldbetrag.parse("00,10");
    Geldbetrag _value2 = Geldbetrag.parse(",1");
    Geldbetrag _value3 = Geldbetrag.parse("00,1");
    Geldbetrag _value4 = Geldbetrag.parse(",10");
    Geldbetrag _value5 = Geldbetrag.parse("0,1");
    String _expected = "00,10";

    @Test
    public void testParse () 
    {
        assertTrue(_value1.equals(_value2));
        assertTrue(_value1.equals(_value3));
        assertTrue(_value1.equals(_value4));
        assertTrue(_value1.equals(_value5));
    }

    @Test
    public void testIsValid ()
    {
        assertTrue(Geldbetrag.isValid("00,10"));
        assertTrue(Geldbetrag.isValid(",1"));
        assertTrue(Geldbetrag.isValid("00,1"));
        assertTrue(Geldbetrag.isValid(",10"));
        assertTrue(Geldbetrag.isValid("0,1"));
    }

    @Test
    public void testEquals ()
    {
        assertTrue(_value1.equals(_value2));
        assertTrue(_value1.equals(_value3));
        assertTrue(_value1.equals(_value4));
        assertTrue(_value1.equals(_value5));
    }

    @Test
    public void testgetString()
    {
        assertEquals(_expected, _value1.getString());
        assertEquals(_expected, _value2.getString());
        assertEquals(_expected, _value3.getString());
        assertEquals(_expected, _value4.getString());
        assertEquals(_expected, _value5.getString());
    }

    @Test
    public void testAdd ()
    {
        String expectedSum = "00,20";
        assertEquals(_value1.add(_value2).getString(), expectedSum);
    }

    @Test
    public void testSub ()
    {
        String expectedSum = "00,00";
        assertEquals(_value1.sub(_value2).getString(), expectedSum);
    }

    @Test
    public void testMultiply ()
    {
        String expectedProduct = "00,40";
        assertEquals(_value1.multiply(4), expectedProduct);
    }

    public void testImmutability ()
    {
        _value1.add(_value2);
        assertEquals(_value1.getString(), _expected);
    }
}