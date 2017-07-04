package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import java.lang.Integer;

/**
 * Eurowert
 */
public final class Geldbetrag
{
    final int _eurocent;

    private Geldbetrag (int eurocent) 
    {
        _eurocent = eurocent;
    }

    /**
     * Wählt einen Eurowert aus (eurocent).
     * 
     * @param eurostring Der Eurowert als String
     * 
     * @require isValid(eurostring)
     * 
     * @ensure getJahr() == jahr
     */
    public static Geldbetrag parse (String eurostring) 
    {
        assert isValid(eurostring) : "Vorbedingung verletzt: isValid(eurocent)";

        int value = Integer.parseInt(eurostring);

        return new Geldbetrag(value);
    }

    public static boolean isValid (String geldbetrag)
    {
        return geldbetrag.matches("^(\d{1,2},\d{1,2}|,\d{1,2}|\d{1,2})$");
    }

    public boolean equals (Geldbetrag geldbetrag)
    {
        // Typzusicherung
        return new Integer(_eurocent).equals(geldbetrag.getAsEurocent());
    }

    public String getString()
    {
        String[] parts = _eurocent.split(_eurocent.length() - 2);
        
        return parts[0];
    }

    public int getAsEurocent()
    {
        return _eurocent;
    }

    public Geldbetrag add (Geldbetrag geldbetrag)
    {}

    public Geldbetrag sub (Geldbetrag geldbetrag)
    {}

    public Geldbetrag multiply (int n)
    {}

}