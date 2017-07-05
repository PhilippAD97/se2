package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{
    private Geldbetrag _value1 = Geldbetrag.parse("00,10");
    private Geldbetrag _value2 = Geldbetrag.parse(",1");
    private Geldbetrag _value3 = Geldbetrag.parse("00,1");
    private Geldbetrag _value4 = Geldbetrag.parse(",10");
    private Geldbetrag _value5 = Geldbetrag.parse("0,1");
    private Geldbetrag _valueMax = Geldbetrag.parse(Integer.MAX_VALUE);
    private String _expected = "00,10";

    @Test
    public void testIsValid()
    {
        assertTrue(Geldbetrag.isValid("00,10"));
        assertTrue(Geldbetrag.isValid(",1"));
        assertTrue(Geldbetrag.isValid("00,1"));
        assertTrue(Geldbetrag.isValid(",10"));
        assertTrue(Geldbetrag.isValid("0,1"));
    }

    @Test
    public void testEquals()
    {
        assertEquals(_value1, _value1);
        assertEquals(_value1, _value2);
        assertEquals(_value1, _value3);
        assertEquals(_value1, _value4);
        assertEquals(_value1, _value5);
    }

    @Test
    public void testGetString()
    {
        assertEquals(_expected, _value1.getString());
        assertEquals(_expected, _value2.getString());
        assertEquals(_expected, _value3.getString());
        assertEquals(_expected, _value4.getString());
        assertEquals(_expected, _value5.getString());
    }

    @Test
    public void testAdd()
    {
        String expectedSum1 = "00,20";
        assertEquals(_value1.add(_value2).getString(), expectedSum1);

        String expectedSum2 = Geldbetrag.parse(Integer.MAX_VALUE).getString();
        assertEquals(_value1.add(_valueMax).getString(), expectedSum2);
    }

    @Test
    public void testSub()
    {
        String expectedSum = "00,00";
        assertEquals(_value1.sub(_value2).getString(), expectedSum);

        assertTrue(_value1.sub(Geldbetrag.parse(10)).getAsEurocent() > 0);
    }

    @Test
    public void testMultiply()
    {
        String expectedProduct = "00,40";
        assertEquals(_value1.multiply(4).getString(), expectedProduct);
    }

    @Test
    public void testImmutability()
    {
        _value1.add(_value2);
        assertEquals(_value1.getString(), _expected);
    }
}